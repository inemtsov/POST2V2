package com.postClient;


/* Author Ilya Nemtsov */

public class Payment {
  private float amount;
  private String paymentType;


  public Payment(float amount){
    this.amount = amount;
  }

  public Payment(float amount, String paymentType) {
    this.amount = amount;
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
}
