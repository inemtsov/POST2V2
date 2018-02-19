package com.post;


/* Author Ilya Nemtsov */


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
    //float calculatedChange = tenderedAmount - getAmount();
    float calculatedChange = tenderedAmount - amount;
    if(calculatedChange >= 0) {
      change = calculatedChange;
    }
    else{
      change = -1.0f;
    }
  }

  public float getChange() {
    return change;
  }
}
