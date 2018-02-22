package sale;

import store.Item;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
*
* @author PeterJayCruz
*/

public class Sale{

    private static final String XML_DECLARATION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private static final String ROOT_ELEMENT_BEGIN = "<transactions>";
    private static final String ROOT_ELEMENT_END = "</transactions>";
    private static final String CUSTOMER_NAME_BEGIN = "<customerName>";
    private static final String CUSTOMER_NAME_END = "</customerName>";
    private static final String MONEY_PAID_BEGIN = "<moneyPaid>";
    private static final String MONEY_PAID_END = "</moneyPaid>";
    private static final String PAYMENT_TYPE_BEGIN = "<paymentType>";
    private static final String PAYMENT_TYPE_END = "</paymentType>";
    private static final String TRANSACTION_ID_BEGIN = "<transactionId>";
    private static final String TRANSACTION_ID_END = "</transactionId>";
    private static final String CREDIT_CARD_NUMBER_BEGIN = "<creditCard>";
    private static final String CREDIT_CARD_NUMBER_END = "</creditCard>";

    private static final String ITEMS_TRANSACTION_BEGIN = "<itemsTransaction>";
    private static final String ITEMS_TRANSACTION_END = "</itemsTransaction>";
    private static final String ITEMS_TRANSACTION_PK_BEGIN = "<itemsTransactionPK>";
    private static final String ITEMS_TRANSACTION_PK_END = "</itemsTransactionPK>";
    private static final String UPC_BEGIN = "<upc>";
    private static final String UPC_END = "</upc>";
    private static final String QUANTITY_BEGIN = "<quantity>";
    private static final String QUANTITY_END = "</quantity>";

    private static Date date;
    private HashMap<String, SaleLineItem> saleLineItems;
    private String paymentType;
    private float subtotal;
    private float amountTendered;
    private String customerName;
    private float moneyChange;
    private int numberOfLineItems;
    private int transactionId;
    private String creditCardNumber;

    public Sale(){
        saleLineItems = new HashMap<>();
        subtotal = 0.0f;
        numberOfLineItems = 0;
        transactionId = (int) (System.currentTimeMillis() & 0xfffffff);
        // System.out.println("ID = " + transactionId);
    }

    public void setCreditCardNumber(String creditCardNumber) {
      this.creditCardNumber = creditCardNumber;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public HashMap<String, SaleLineItem> getSaleLineItems() {
        return saleLineItems;
    }

    public void setSaleLineItems(HashMap<String, SaleLineItem> saleLineItems) {
        this.saleLineItems = saleLineItems;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getAmountTendered() {
        return amountTendered;
    }

    public void setAmountTendered(float amountTendered) {
        this.amountTendered = amountTendered;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public float getMoneyChange() {
        return moneyChange;
    }

    public void setMoneyChange(float moneyChange) {
        this.moneyChange = moneyChange;
    }

    public void addSaleLineItem(Item item, int quantity) {
        numberOfLineItems += 1;
        saleLineItems.put(Integer.toString(numberOfLineItems), new SaleLineItem(item, quantity));
        subtotal += item.getPrice() * quantity;
    }

    /*
        Payment is saved once the user clicks "pay" on the post.
    */
    public void saveIntoDatabase(){
      saveTransactionDataToDatabase();
      saveInvoiceItemListToDatabase();
    }

    private void saveTransactionDataToDatabase() {
      try {
        //Attempts to connect to the server.
        URL urlPerson = new URL("http://localhost:8080/PostServer/webresources/com.postentity.transactions");
        HttpURLConnection postConnPerson = (HttpURLConnection) urlPerson.openConnection();
        postConnPerson.setDoOutput(true);
        postConnPerson.setRequestMethod("POST");
        postConnPerson.setRequestProperty("Content-Type", "application/xml");

        //Concatenate new transaction.xml string in the formal shown below.
        String newTransactionSalesLineItem =
                       XML_DECLARATION + "\n"
                +      ROOT_ELEMENT_BEGIN + "\n"
                +      CUSTOMER_NAME_BEGIN + customerName + CUSTOMER_NAME_END + "\n"
                +      MONEY_PAID_BEGIN + amountTendered + MONEY_PAID_END + "\n"
                +      PAYMENT_TYPE_BEGIN + paymentType + PAYMENT_TYPE_END + "\n"
                +      TRANSACTION_ID_BEGIN + transactionId + TRANSACTION_ID_END + "\n"
                +      CREDIT_CARD_NUMBER_BEGIN + creditCardNumber + CREDIT_CARD_NUMBER_END + "\n"
                +      ROOT_ELEMENT_END;

        // System.out.println(newTransactionSalesLineItem);
        OutputStream postOutputStream = postConnPerson.getOutputStream();
        postOutputStream.write(newTransactionSalesLineItem.getBytes());
        postOutputStream.flush();

        //Throws runtimeException if error code is 400 or greater
        if (postConnPerson.getResponseCode() >= 400) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + postConnPerson.getResponseCode());
        }

        //Prints out response from the server, then disconnects
        String output = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                (postConnPerson.getInputStream())));
        System.out.println("Output from Server .... \n");
        while ((output = bufferedReader.readLine()) != null)
        {
          System.out.println(output);
        }
        postConnPerson.disconnect();

        } catch (MalformedURLException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

    public void saveInvoiceItemListToDatabase() {
      Iterator it = saleLineItems.entrySet().iterator();
      while(it.hasNext()) {
        Map.Entry pair = (Map.Entry) it.next();
        SaleLineItem sli = (SaleLineItem) pair.getValue();
        // System.out.println("upc = " + sli.getItem().getUPC() + " quantity = " + sli.getQuantity());
        String upc = sli.getItem().getUPC();
        int quantity = sli.getQuantity();
        // System.out.println("upc = " + upc);
        // System.out.println("quantity = " + quantity);

        try {
          //Attempts to connect to the server.
          URL urlPerson = new URL("http://localhost:8080/PostServer/webresources/com.postentity.itemstransaction");
          HttpURLConnection postConnPerson = (HttpURLConnection) urlPerson.openConnection();
          postConnPerson.setDoOutput(true);
          postConnPerson.setRequestMethod("POST");
          postConnPerson.setRequestProperty("Content-Type", "application/xml");

          //Concatenate new transaction.xml string in the formal shown below.
          String newTransactionSalesLineItem =
                        ITEMS_TRANSACTION_BEGIN + "\n"
                  +      TRANSACTION_ID_BEGIN + this.transactionId + TRANSACTION_ID_END + "\n"
                  +      UPC_BEGIN + upc + UPC_END + "\n"
                  +      QUANTITY_BEGIN + quantity + QUANTITY_END + "\n"
                  +      ITEMS_TRANSACTION_END;

          System.out.println(newTransactionSalesLineItem);
          OutputStream postOutputStream = postConnPerson.getOutputStream();
          postOutputStream.write(newTransactionSalesLineItem.getBytes());
          postOutputStream.flush();

          //Throws runtimeException if error code is 400 or greater
          if (postConnPerson.getResponseCode() >= 400) {
              throw new RuntimeException("Failed : HTTP error code : "
                      + postConnPerson.getResponseCode());
          }

          //Prints out response from the server, then disconnects
          String output = "";
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                  (postConnPerson.getInputStream())));
          System.out.println("Output from Server .... \n");
          while ((output = bufferedReader.readLine()) != null)
          {
            System.out.println(output);
          }
          postConnPerson.disconnect();

          } catch (MalformedURLException e) {
            e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
          }
      }
    }

    @Override
    public String toString(){
     String s="";
     for (Map.Entry<String, SaleLineItem> entry : saleLineItems.entrySet()) {
            SaleLineItem value = entry.getValue();
            s+="<html>" + value.getItem().getDescription() + " " + value.getQuantity()+ " @ $"+ String.format("%.2f", value.getItem().getPrice()) +"<br>";
     }
     return s;
    }
}
