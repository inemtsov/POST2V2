import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* Author Ilya Nemtsov */

public class ProductCatalog {

  private String line;
  private BufferedReader source;
  private HashMap<String, Item> products;
  private static ArrayList<String> listOfUPC = new ArrayList<String>();
  public ProductCatalog( ) {
      try{
            this.products = new HashMap<>();
            URL urlPersonName = new URL("http://localhost:8080/PostServer/webresources/com.postentity.products");
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
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
  }

  public static String[] getAllUpc() throws IOException  {
    //new ProductCatalog( "products.txt" );//temporray since manager is not setting this up
    String[] arr = new String[listOfUPC.size()];
    for(int i =0; i<arr.length; i++){
        arr[i]=listOfUPC.get(i);
    }
    return arr;
  }
  
  public Item getItem( String UPC ) {
    return products.get( UPC );
  }
}
