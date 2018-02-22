package payment;

/* Author Ilya Nemtsov */

public class Check extends Payment {

  private float checkAmount;
  private boolean transactionStatus;

  public Check(float amount, float checkAmount) {
    super( amount );
    this.checkAmount = checkAmount;
    processCheck();
  }

  public float getCheckAmount() {
    return checkAmount;
  }
  
   private void processCheck() {

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
