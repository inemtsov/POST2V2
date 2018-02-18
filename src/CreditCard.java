/* Author Ilya Nemtsov */

public class CreditCard extends Payment {

  private String cardNumber;
  private boolean transactionStatus;

  public CreditCard(float amount, String cardNumber) {
    super( amount );
    this.cardNumber = cardNumber;
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
}
