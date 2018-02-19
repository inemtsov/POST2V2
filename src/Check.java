/* Author Ilya Nemtsov */

public class Check extends Payment {

  private float checkAmount;
  private boolean transactionStatus;

  public Check(float amount, float checkAmount) {
    super( amount );
    this.checkAmount = checkAmount;
  }

}
