package payment;

/**
*
* @author ilyanemtsov
*/

public class Cash extends Payment {

  private float tenderedAmount;
  private float change;
  private float amount;

  public Cash(float amount, float tenderedAmount) {
    super(amount);
    this.amount = amount;
    this.tenderedAmount = tenderedAmount;
    change = 0.0f;
    calculateChange();
  }

  private void calculateChange() {
      change = tenderedAmount - amount;
  }

  public float getChange() {
    return change;
  }

  public float getTenderedAmount() {
    return tenderedAmount;
  }
}
