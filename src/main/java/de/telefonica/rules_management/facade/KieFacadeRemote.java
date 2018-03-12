package de.telefonica.rules_management.facade;

import javax.ejb.*;

import de.telefonica.rules_management.facts.*;

@Remote
public interface KieFacadeRemote
{
  public int fireRules(Customer customer);
}