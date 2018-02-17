
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniellenunez
 */
public class PanelMediator {
    private ProductCatalog productCatalog;
    private Sale sale;
    
    PostFrame framePayment;

    public PanelMediator(ProductCatalog productCatalog){
        this.productCatalog = productCatalog; 
        sale = new Sale();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                framePayment = new PostFrame();
                framePayment.setVisible(true);
                setDate();                
                interactPanel();
            }
        });
    }
        
    public void setDate(){
        Date date = new Date();
        framePayment.setSaleDate(date.toString());
        sale.setDate(date);
    }
    
    public void setProductCatalog(ProductCatalog productCatalog)
    {
        this.productCatalog = productCatalog;
    }
    
    public void setSale(Sale sale)
    {
        this.sale = sale;
    }
    
    public Item getItem(String upc)
    {
        return this.productCatalog.getItem(upc);
    }
    
    public void setName(String name)
    {
        
    }
    
    public void interactPanel(){
        framePayment.getProductPanel().getComponent(4).addMouseListener(new java.awt.event.MouseAdapter() {
                           
           @Override
           public void mouseClicked(java.awt.event.MouseEvent evt) {
               if(!framePayment.getCustomerNamePanel().getCustomerName().isEmpty()){
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
               if(framePayment.getCustomerNamePanel().getCustomerName().isEmpty()){
                  framePayment.popUpCustomerName(); 
               } 
               else if(framePayment.getPaymentPanel().getPaymentTextfield().isEmpty()){
                   framePayment.popUpPaymentInfo();
               }    
               else {
                   if(sale.getSaleLineItems().isEmpty()){
                       framePayment.popUpEmptyCart();
                   }
                   else{
                       switch(framePayment.getPaymentPanel().getSelectedPaymentType()){
                          
                           case "Cash":
                               if(Float.parseFloat(framePayment.getPaymentPanel().getPaymentTextfield())<sale.getSubtotal()){
                                    framePayment.popUpPaymentRejected();
                               }
                               else{
                                   Cash pay = new Cash(sale.getSubtotal(), Float.parseFloat(framePayment.getPaymentPanel().getPaymentTextfield()));
                                   framePayment.popUpCashChange("Your change is $"+pay.getChange());
                                   saleCompleted();
                               }
                            break;
                           case "Check":
                               Check check = new Check(sale.getSubtotal(), framePayment.getPaymentPanel().getPaymentTextfield());
                               if(!check.isApproved()){
                                    framePayment.popUpCheckRejected();
                               }
                               else{
                                   saleCompleted();
                               }
                            break;
                           case "Credit Card":
                               CreditCard credit = new CreditCard(sale.getSubtotal(), framePayment.getPaymentPanel().getPaymentTextfield());
                               if(!credit.isApproved()){
                                    framePayment.popUpCreditCardRejected();
                               }
                               else{
                                   saleCompleted();
                               }
                            break;
                       }
                   }
               }
           }
       });
        
    }
    
    public void saleCompleted(){
        framePayment.popUpSaleCompleted();
        sale.setPaymentType(framePayment.getPaymentPanel().getSelectedPaymentType());
        sale.setCustomerName(framePayment.getCustomerNamePanel().getCustomerName());
        
        //save sale info
        //send data into database
        //reset everything to blank
        
    }
}

