/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Justin
 */
public class PostDBGet{
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        try{
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
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
