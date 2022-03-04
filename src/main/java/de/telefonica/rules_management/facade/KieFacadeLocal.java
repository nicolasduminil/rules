package de.telefonica.rules_management.facade;

import javax.ejb.*;

import de.telefonica.rules_management.facts.*;

import java.io.*;

@Local
public interface KieFacadeLocal
{
  public int fireRules (Customer customer);
}
