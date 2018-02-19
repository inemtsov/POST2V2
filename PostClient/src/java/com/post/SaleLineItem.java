package com.post;

/* Author Peter Cruz */

public class SaleLineItem {

  private Item item;
  private int quantity;

  public SaleLineItem(Item item, int quantity) {
    this.item = item;
    this.quantity = quantity;
  }

  public Item getItem() {
    return item;
  }

  public int getQuantity() {
    return quantity;
  }
}
