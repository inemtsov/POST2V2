import java.util.*;

public class Sale{
    private static Date date;
    private HashMap<String, SaleLineItem> saleLineItems;
    private Payment paymentType;
    private float subtotal;
    private float amountTendered;
    
    public Sale() 
    {
        saleLineItems = new HashMap<String, SaleLineItem>();
        date = new Date();
    }  
    
    public static Date getDate() 
    {
        return date;
    }
    
    /*
        Payment is saved once the user clicks "pay" on the post.
    */
    public void saveIntoDatabase()
    {
        
    }
    
    public String calculateSubtotalForItem(Item item)
    {
        
    }
}

//import java.util.*;
//
///* Author Peter Cruz */
//
//public class Sale {
//
//  private Store store;
//  private static Date date;
//  private HashMap<String, SaleLineItem> saleLineItems;
//
//  private Payment paymentType;
//  private Customer customer;
//  private float subtotal;
//  private float amountTendered;
//
//  public Sale() {
//    saleLineItems = new HashMap<String, SaleLineItem>();
//    date = new Date();
//    subtotal = 0.0f;
//    
//  }  
//  public void addSaleLineItem(String upc, int quantity) {
//    Item item = store.getItemFromProductCatalog(upc);
//    saleLineItems.put(upc, new SaleLineItem(item, quantity));
//    subtotal += item.getPrice() * quantity;
//  }
//
//  public void removeSaleLineItem(int upc) {
//    subtotal -= saleLineItems.get(upc).getItem().getPrice() * saleLineItems.get(upc).getQuantity();
//    saleLineItems.remove(upc);
//  }
//
//  public float initiatePayment(Payment paymentType, float subtotal, float amountTendered) {
//    float change = 0.0f;
//    switch (paymentType.getPaymentType()) {
//      case "CASH":
//        Cash cash = new Cash (subtotal, amountTendered);
//        change = cash.getChange();
//        break;
//      case "CHECK":
//        Check check = new Check (subtotal);
//        break;
//      case "CREDIT":
//        CreditCard credit = new CreditCard(subtotal, paymentType.getCreditCardNumber());
//        break;
//    }
//    return change;
//  }
//
//  public void printReceipt() {
//    System.out.println("STORE NAME");
//    System.out.println(getStore().getSTORE_NAME());
//    System.out.print(getCustomer().getCustomerName());
//    System.out.print("\t");
//    System.out.println(getDate());
//
//    float subtotal, sum = 0.0f;
//    for (String key : saleLineItems.keySet()){
//      subtotal = 0.0f;
//      System.out.print(saleLineItems.get(key).getItem().getDescription()+" ");
//      System.out.print(saleLineItems.get(key).getQuantity());
//      System.out.print(" @ ");
//      System.out.print("$");
//      System.out.printf("%.2f ", saleLineItems.get(key).getItem().getPrice());
//      subtotal += saleLineItems.get(key).getQuantity()*saleLineItems.get(key).getItem().getPrice();
//      System.out.print("$");
//      System.out.printf("%.2f\n", subtotal);
//
//      sum += subtotal;
//    }
//    System.out.println("- - - - - -");
//    System.out.print("Total: $");
//    System.out.printf("%.2f\n", sum);
//    this.subtotal = sum;
//    //System.out.println(sum);
//
//    //calculate the returned amount
//    float change = initiatePayment(paymentType, sum, paymentType.getAmount());
//
//    switch (paymentType.getPaymentType()){
//      case "CASH":
//        System.out.print("Amount tendered: $");
//        this.amountTendered = paymentType.getAmount();
//        System.out.printf("%.2f\n", amountTendered);
//        //System.out.println(paymentType.getAmount());
//
//        System.out.print("Amount Returned: $");
//        System.out.printf("%.2f\n", change);
//        //System.out.println(change);
//
//        break;
//      case "CHECK":
//        System.out.println("Paid by check");
//        break;
//      case "CREDIT":
//        System.out.print("Paid by Credit Card ");
//        System.out.println(paymentType.getCreditCardNumber());
//        break;
//    }
//
//    System.out.println();
//
//  }
//
//
//  /*ALL GETTERS AND SETTERS!*/
//
//  public Store getStore() {
//    return store;
//  }
//
//  public static Date getDate() {
//    return date;
//  }
//
//  public HashMap<String, SaleLineItem> getSaleLineItems() {
//    return saleLineItems;
//  }
//
//  public Payment getPaymentType() {
//    return paymentType;
//  }
//
//  public Customer getCustomer() {
//    return customer;
//  }
//
//  public float getSubtotal() {
//    return subtotal;
//  }
//
//  public float getAmountTendered() {
//    return amountTendered;
//  }
//
//  public void setStore(Store storename) {
//    this.store = storename;
//  }
//
//  public void setDate(Date date) {
//    this.date = date;
//  }
//
//  public void setPaymentCash(String paymentType, float amount) {
//    Payment pay = new Payment(amount, paymentType);
//    this.paymentType = pay;
//  }
//
//  public void setPaymentCheck(String paymentType, float amount) {
//    Payment pay = new Payment(amount, paymentType);
//    this.paymentType = pay;
//  }
//
//  public void setPaymentCredit(String paymentType, String creditNumber) {
//    Payment pay = new Payment(paymentType, creditNumber);
//    this.paymentType = pay;
//  }
//
//
//  public void setCustomerName(String customerName) {
//    Customer c = new Customer(customerName);
//    this.customer = c;
//  }
//
//  public void setSubtotal(float subtotal) {
//    this.subtotal = subtotal;
//  }
//
//  public void setAmountTendered(float amountTendered) {
//    this.amountTendered = amountTendered;
//  }
//
//
//}


