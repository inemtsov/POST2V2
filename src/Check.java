/* Author Ilya Nemtsov */

public class Check extends Payment {

  private float tenderedAmount;
  private boolean transactionStatus;

  public Check( float amount) {
    super(amount);
    transactionStatus = false;
  }

}
