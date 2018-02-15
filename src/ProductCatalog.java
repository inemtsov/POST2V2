import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* Author Ilya Nemtsov */

public class ProductCatalog {

  private String line;
  private BufferedReader source;
  private HashMap<String, Item> products;
  private static ArrayList<String> listOfUPC = new ArrayList<String>();
  public ProductCatalog( String fileName ) throws IOException {
    try {
        
      source = new BufferedReader( (new FileReader( fileName )) );
      products = new HashMap<>();
      load();
    }catch( IOException e ) {
      source = null;
    }
  }

  private boolean hasMoreProducts() throws IOException {
    line = nextLine();
    return line == null ? false : true;
  }

  private String nextLine() throws IOException {
    try {
      return source.readLine();
    }catch( Exception e ) {
      return null;
    }
  }

  private String getNextProduct() {
    return line;
  }

  private void load() throws IOException {
    String currentLine;
    while( hasMoreProducts() ) {
      currentLine = getNextProduct();

      products.put( currentLine.substring( 0, 4 ), new Item( currentLine.substring( 0, 4 ), currentLine.substring( 9, 29 ), Float.valueOf( currentLine.substring( 34 ) ) ) );
      listOfUPC.add(currentLine.substring( 0, 4 ));
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
