/* Author Ilya Nemtsov */

public class Check extends Payment {

  private String checkNumber;
  private boolean transactionStatus;

  public Check(float amount, String checkNumber) {
    super( amount );
    this.checkNumber = checkNumber;
    processCheck();
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
