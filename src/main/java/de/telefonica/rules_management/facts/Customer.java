package de.telefonica.rules_management.facts;

import java.io.*;

public class Customer implements Serializable
{
  private static final long serialVersionUID = 1L;

  private CustomerType type;
  private int years;
  private int discount;

  public Customer(CustomerType type, int years)
  {
    this.type = type;
    this.years = years;
  }

  public CustomerType getType()
  {
    return type;
  }

  public void setType(CustomerType type)
  {
    this.type = type;
  }

  public int getYears()
  {
    return years;
  }

  public void setYears(int years)
  {
    this.years = years;
  }

  public int getDiscount()
  {
    return discount;
  }

  public void setDiscount(int discount)
  {
    this.discount = discount;
  }

  public enum CustomerType
  {
    INDIVIDUAL, BUSINESS;
  }
}
