
/* Author Ilya Nemtsov */

public class Payment {
  private float amount;
  private String paymentType;
  private String creditCardNumber;


  public Payment(float amount){

  }

  public Payment(float amount, String paymentType) {
    this.amount = amount;
    this.paymentType = paymentType;
  }

  public Payment(String paymentType, String creditCardNumber){
    this.creditCardNumber = creditCardNumber;
    this.paymentType = paymentType;
  }

  public float getItemCost() {
    return amount;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public String getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }
}
