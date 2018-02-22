package payment;

/**
 *
 * @author ilyanemtsov
 */

public class CreditCard extends Payment {

  private String cardNumber;
  private boolean transactionStatus;
  private float creditAmount;

  public CreditCard(float amount, String cardNumber, float creditAmount) {
    super( amount );
    this.cardNumber = cardNumber;
    this.creditAmount = creditAmount;
    processCard();
  }

  private void processCard() {

    double random = Math.random();
    if(random<=0.1){
       transactionStatus = false;
    }
    else{
       transactionStatus = true;
    }
  }

  public boolean isApproved() {
    return transactionStatus;
  }

  public float getCreditAmount() {
    return creditAmount;
  }

  public String getCreditCardNumber() {
    return cardNumber;
  }
}
