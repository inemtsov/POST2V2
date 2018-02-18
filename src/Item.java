
/* Author Ilya Nemtsov */

public class Item {

  private String description;
  private String UPC;
  private float price;

  public Item( String UPC, String description, float price ) {

    this.description = description;
    this.price = price;
    this.UPC = UPC;
  }

  public Item() {
    this.description = "N/A";
    this.price = 0.0f;
    this.UPC = "----";
  }

  public String getUPC() {
    return UPC;
  }

  public void setUPC( String UPC ) {
    this.UPC = UPC;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice( float price ) {
    this.price = price;
  }

  public String getDescription() {

    return description;
  }

  public void setDescription( String description ) {
    this.description = description;
  }

  @Override
  public String toString() {
    return getUPC() + " " + getDescription() + " " + getPrice();
  }
}
