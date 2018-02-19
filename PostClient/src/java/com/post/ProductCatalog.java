package com.post;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.GET;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* Author Ilya Nemtsov */

public class ProductCatalog {
    
  private HashMap<String, Item> products;
  private static ArrayList<String> listOfUPC = new ArrayList<String>();
  
  
  /*
  Constructor for the product catalog. Initializes an ArrayList of
  all valid UPCs from the databse by using a rest GET methos. 
  @param    none
  @return   An instance of the ProductCatalog. 
  */
  public ProductCatalog() 
  {
      try{
            this.products = new HashMap<>();
            URL urlPersonName = new URL("http://localhost:8080/PostClient/webresources/com.postentity.products");
            HttpURLConnection getConnPersonName = (HttpURLConnection) urlPersonName.openConnection();
            getConnPersonName.setRequestMethod("GET");
            getConnPersonName.setRequestProperty("Accept", "application/xml");
            
            if (getConnPersonName.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + getConnPersonName.getResponseCode());
            }
            int byteLen = getConnPersonName.getInputStream().available();
            byte[] bytes = new byte[byteLen];
            getConnPersonName.getInputStream().read(bytes, 0, byteLen);
            for(int i = 0; i < byteLen; i++){
                System.out.print((char)bytes[i]);
            }
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(bytes));
            NodeList products = doc.getElementsByTagName("products");
            System.out.println();
            System.out.println(products.getLength());
            
            for(int i = 0; i < products.getLength(); i++){
                Element element = (Element)products.item(i);
                String upc = element.getElementsByTagName("upc").item(0).getTextContent();
                String description = element.getElementsByTagName("description").item(0).getTextContent();
                String price = element.getElementsByTagName("price").item(0).getTextContent();
                System.out.println(upc + " " + description + " " + price);
                this.products.put(upc, new Item(upc, description, Float.parseFloat(price)));
                this.listOfUPC.add(upc);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
  }

  /*
    Returns an array of strings created during the constructor of all valid UPCs
  from the database. 
  @param    none
  @return   An array of Strings containing all of the UPCs pulled from the database. 
  */
  public static String[] getAllUpc() throws IOException  
  {
    //new ProductCatalog( "products.txt" );//temporray since manager is not setting this up
    String[] arr = new String[listOfUPC.size()];
    for(int i =0; i<arr.length; i++)
    {
        arr[i]=listOfUPC.get(i);
    }
    return arr;
  }
  
  /*
    Given a String UPC of an item, returns the item object
  that corresponds with the given UPC. 
  @param    A UPC of an item given in a String form
  @return   An item object that corresponds from the given UPC. 
  */
  public Item getItem( String UPC ) 
  {
    return products.get( UPC );
  }
}
