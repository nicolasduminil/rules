package de.telefonica.rules_management;

import java.util.*;

import javax.naming.*;

import org.junit.*;

import de.telefonica.rules_management.facade.*;
import de.telefonica.rules_management.facts.*;
import de.telefonica.rules_management.facts.Customer.*;

public class TestFacade
{
  @Test
  public void test() throws Exception
  {
    Hashtable<String, String> props = new Hashtable<String, String>();
    props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
    props.put(Context.PROVIDER_URL, "t3://localhost:7001"); 
    KieFacadeRemote facade = (KieFacadeRemote) new InitialContext(props).lookup("java:global.rules-manager.KieFacade!de.telefonica.rules_management.facade.KieFacadeRemote");
    Assert.assertEquals(15, facade.fireRules(new Customer(CustomerType.INDIVIDUAL, 5)));
  }
}
