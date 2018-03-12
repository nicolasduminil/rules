package de.telefonica.rules_management.facade;

import de.telefonica.rules_management.facts.*;
import de.telefonica.rules_management.facts.Customer.*;

public class Rules
{
  public void applyDiscount (Customer customer)
  {
    if (customer.getType().equals(CustomerType.INDIVIDUAL))
    {
      if (customer.getYears() >= 3)
        customer.setDiscount(15);
      else if (customer.getYears() >=0 && customer.getYears() < 3)
        customer.setDiscount(3);
    }
    else if (customer.getType().equals(CustomerType.BUSINESS))
      customer.setDiscount(20);
    // ...
  }
}
