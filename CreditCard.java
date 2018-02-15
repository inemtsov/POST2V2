/* Author Ilya Nemtsov */

public class CreditCard extends Payment {

  private float tenderedAmount;
  private String cardNumber;
  private boolean transactionStatus;

  public CreditCard( float amount, String cardNumber ) {
    super( amount );
    this.cardNumber = cardNumber;
    processCard();
  }

  private void processCard() {
    if(cardNumber.length() == 5) {
      transactionStatus = true;
    }
    else{
      transactionStatus = false;
    }
  }

  public boolean isApproved() {
    return transactionStatus;
  }
}
