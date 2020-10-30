package com.example.entities;


public class Storage {

  private long id;
  private long productId;
  private long total;
  private long used;
  private long residue;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }


  public long getUsed() {
    return used;
  }

  public void setUsed(long used) {
    this.used = used;
  }


  public long getResidue() {
    return residue;
  }

  public void setResidue(long residue) {
    this.residue = residue;
  }

}
