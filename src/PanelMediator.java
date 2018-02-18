
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
                                        Cash pay = new Cash(sale.getSubtotal(), Float.parseFloat(framePayment.getPaymentPanel().getPaymentTextfield()));
                                        framePayment.popUpCashChange("Your change is $" + pay.getChange());
                                        saleCompleted();
                                    }
                                } catch (NumberFormatException e) {
                                    framePayment.popUpPaymentRejected();
                                }

                                break;
                            case "Check":
                                if (framePayment.getPaymentPanel().getPaymentTextfield().matches("[0-9]+")) {
                                    Check check = new Check(sale.getSubtotal(), framePayment.getPaymentPanel().getPaymentTextfield());
                                    if (!check.isApproved()) {
                                        framePayment.popUpCheckRejected();
                                    } else {
                                        saleCompleted();
                                    }
                                } else {
                                    framePayment.popUpPaymentRejected();
                                }
                                break;
                            case "Credit Card":
                                if (framePayment.getPaymentPanel().getPaymentTextfield().matches("[0-9]+")) {
                                    CreditCard credit = new CreditCard(sale.getSubtotal(), framePayment.getPaymentPanel().getPaymentTextfield());
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
        System.out.print(s);
        String transaction =
                "<html><body width = 275, length = 1800 ><h1>SFSU BookStore<br><br>"+ 
                "<p>" + sale.getCustomerName()+ "<br><br>"  + 
                 s + "<br><br>"+
                "<p>" +"--------------"+"<br><br>"+
                "<p>" +sale.getSubtotal()+"<br><br>"+
                "<p>" +sale.getPaymentType()+"<br><br>"+
                "<p>" +sale.getDate().toString() +"<br><br>";
             

       JOptionPane.showMessageDialog(null, transaction);

    }
    
}
