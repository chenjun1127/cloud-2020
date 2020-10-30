package com.example.entities;


public class Account {

  private long id;
  private long userId;
  private double total;
  private double used;
  private double residue;


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


  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }


  public double getUsed() {
    return used;
  }

  public void setUsed(double used) {
    this.used = used;
  }


  public double getResidue() {
    return residue;
  }

  public void setResidue(double residue) {
    this.residue = residue;
  }

}
