package store;


public class Store {

  private String STORE_NAME = "CSC668 Store";
  private String ADDRESS = "123 store street";
  private ProductCatalog productCatalog;

  public Store(String name) {
    this.STORE_NAME = name;
  }

  public Store(String storeName, String address, ProductCatalog pCatalog){
    this.STORE_NAME = storeName;
    this.ADDRESS = address;
    this.productCatalog = pCatalog;
  }

  public String getSTORE_NAME() {
    return STORE_NAME;
  }

  public String getADDRESS() {
    return ADDRESS;
  }

  public ProductCatalog getProductCatalog() {
    return productCatalog;
  }

  public Item getItemFromProductCatalog(String upc) {
    return productCatalog.getItem(upc);
  }

  public void setProductCatalog(ProductCatalog productCatalog) {
    this.productCatalog = productCatalog;
  }

  public void setSTORE_NAME(String STORE_NAME) {
    this.STORE_NAME = STORE_NAME;
  }

  public void setADDRESS(String ADDRESS) {
    this.ADDRESS = ADDRESS;
  }
}
