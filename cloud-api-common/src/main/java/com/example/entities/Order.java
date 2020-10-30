package com.example.entities;


import java.math.BigDecimal;

public class Order {

  private long id;
  private long userId;
  private long productId;
  private int count;
  private BigDecimal money;
  private long status;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }


  public BigDecimal getMoney() {
    return money;
  }

  public void setMoney(BigDecimal money) {
    this.money = money;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}
