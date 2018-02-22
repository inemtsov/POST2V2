package gui;

import sale.Sale;
import store.Item;
import store.ProductCatalog;
import payment.Cash;
import payment.CreditCard;
import payment.Check;
import java.util.Date;

/**
*
* @author leirelitwin
*/

public class PanelMediator {

    private ProductCatalog productCatalog;
    private Sale sale;

    PostFrame framePayment;

    public PanelMediator(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                framePayment = new PostFrame();
                framePayment.setVisible(true);
                setDate();
                interactPanel();
            }

        });
        startNewSale();
    }

    public void startNewSale() {
        sale = null;
        sale = new Sale();
    }

    public void reset() {
        setDate();
        framePayment.getInvoicePanel().reset();
        framePayment.getCustomerNamePanel().reset();
        framePayment.getProductPanel().reset();
        framePayment.getPaymentPanel().reset();
    }

    public void setDate() {
        Date date = new Date();
        framePayment.setSaleDate(date.toString());
        sale.setDate(date);
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Item getItem(String upc) {
        return this.productCatalog.getItem(upc);
    }

    public void setName(String name) {

    }

    public void interactPanel() {
        framePayment.getProductPanel().getComponent(4).addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (!framePayment.getCustomerNamePanel().getCustomerName().isEmpty()) {
                    framePayment.getCustomerNamePanel().getComponent(1).setEnabled(false);

                    String description = productCatalog.getItem(framePayment.getProductPanel().getSelectedUPC()).getDescription();
                    int quantity = framePayment.getProductPanel().getSelectedQuantity();
                    float price = productCatalog.getItem(framePayment.getProductPanel().getSelectedUPC()).getPrice();
                    framePayment.getInvoicePanel().setLineItem(description, quantity, price);
                    sale.addSaleLineItem(productCatalog.getItem(framePayment.getProductPanel().getSelectedUPC()), quantity);

                    framePayment.getInvoicePanel().setTotalTextfield("$" + String.format("%.2f", sale.getSubtotal()));

                } else {
                    framePayment.popUpCustomerName();
                }
            }
        });

        framePayment.getPaymentPanel().getComponent(2).addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (framePayment.getCustomerNamePanel().getCustomerName().isEmpty()) {
                    framePayment.popUpCustomerName();
                } else if (framePayment.getPaymentPanel().getPaymentTextfield().isEmpty()) {
                    framePayment.popUpPaymentInfo();
                } else {
                    if (sale.getSaleLineItems().isEmpty()) {
                        framePayment.popUpEmptyCart();
                    } else {
                        switch (framePayment.getPaymentPanel().getSelectedPaymentType()) {

                            case "Cash":
                                try {
                                    Float.parseFloat(framePayment.getPaymentPanel().getPaymentTextfield());

                                    if (Float.parseFloat(framePayment.getPaymentPanel().getPaymentTextfield()) < sale.getSubtotal()) {
                                        framePayment.popUpPaymentRejected();
                                    } else {
                                        Cash cash = new Cash(sale.getSubtotal(), Float.parseFloat(framePayment.getPaymentPanel().getPaymentTextfield()));
                                        sale.setAmountTendered(cash.getTenderedAmount());
                                        framePayment.popUpCashChange("Your change is $" + String.format("%.2f", cash.getChange()));
                                        saleCompleted();
                                    }
                                } catch (NumberFormatException e) {
                                    framePayment.popUpPaymentRejected();
                                }

                                break;
                            case "Check":
                                try {
                                    Float.parseFloat(framePayment.getPaymentPanel().getPaymentTextfield());

                                    if (Float.parseFloat(framePayment.getPaymentPanel().getPaymentTextfield()) != sale.getSubtotal()) {
                                        framePayment.popUpPaymentRejected();
                                    } else {
                                        Check check = new Check(sale.getSubtotal(), Float.parseFloat(framePayment.getPaymentPanel().getPaymentTextfield()));
                                        sale.setAmountTendered(check.getCheckAmount());
                                        if (!check.isApproved()) {
                                            framePayment.popUpCreditCardRejected();
                                        } else {
                                            saleCompleted();

                                        }
                                    }
                                } catch (NumberFormatException e) {
                                    framePayment.popUpPaymentRejected();
                                }
                                break;
                            case "CreditCard":
                                if (framePayment.getPaymentPanel().getPaymentTextfield().matches("[0-9]+")) {
                                    CreditCard credit = new CreditCard(sale.getSubtotal(), framePayment.getPaymentPanel().getPaymentTextfield(), sale.getSubtotal());
                                    sale.setAmountTendered(credit.getCreditAmount());
                                    sale.setCreditCardNumber(credit.getCreditCardNumber());
                                    if (!credit.isApproved()) {
                                        framePayment.popUpCreditCardRejected();
                                    } else {
                                        saleCompleted();
                                    }
                                } else {
                                    framePayment.popUpPaymentRejected();
                                }
                                break;
                        }
                    }
                }
            }
        });

    }

    public void saleCompleted() {
        framePayment.popUpSaleCompleted();

        //save sale info
        sale.setPaymentType(framePayment.getPaymentPanel().getSelectedPaymentType());
        sale.setCustomerName(framePayment.getCustomerNamePanel().getCustomerName());
        printTransaction();
        sale.saveIntoDatabase(); //send data into database

        reset();
        startNewSale();
    }

    public void printTransaction() {
        String s = sale.toString();
        String transaction
                = "<html><body width = 275, length = 1800><h1>1st Store<br><br>"
                + "<p>" + "<h3>Customer Name: " + sale.getCustomerName() + "<br><br> "
                + "<p>" + "List of products:<br>"
                + "<p>" + "-----------------" + "<br>"
                + s + "<br>"
                + "<p>" + "-----------------" + "<br><br>"
                + "<p>" + "Subtotal: $" + String.format("%.2f", sale.getSubtotal()) + "<br><br>"
                + "<p>" + "Payment type: " + sale.getPaymentType() + "<br><br>"
                + "<p>" + "Sale date: " + sale.getDate().toString() + "<br><br>";

                framePayment.popUpTransactionInfo(transaction);
    }

}
