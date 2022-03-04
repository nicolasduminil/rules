package de.telefonica.rules_management;

import de.telefonica.rules_management.facade.*;
import de.telefonica.rules_management.facts.*;
import de.telefonica.rules_management.facts.Customer.*;
import org.junit.*;

import javax.naming.*;
import java.util.*;

import static org.junit.Assert.*;

public class TestFacade
{
  private static KieFacadeRemote kieFacadeRemote;

  @BeforeClass
  public static void before() throws Exception
  {
    Hashtable<String, String> props = new Hashtable<>();
    props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
    props.put(Context.PROVIDER_URL, "t3://localhost:7001");
    kieFacadeRemote = (KieFacadeRemote) new InitialContext(props)
      .lookup("java:global.rules-manager.KieFacade!de.telefonica.rules_management.facade.KieFacadeRemote");
  }

  @Test
  public void givenRemoteKieIsNotNullThenSucceed()
  {
    assertNotNull(kieFacadeRemote);
  }

  @Test
  public void givenLongDateIndividualCustomerWhenFireRuleThenCorrectDiscount()
  {
    Customer customer = new Customer(CustomerType.INDIVIDUAL, 5);
    assertEquals(kieFacadeRemote.fireRules(customer), 15);
  }

  @Test
  public void givenShortDateIndvidualCustomerWhenFireRuleThenCorrectDiscount()
  {
    Customer customer = new Customer(CustomerType.INDIVIDUAL, 1);
    assertEquals(kieFacadeRemote.fireRules(customer), 5);
  }

  @Test
  public void givenBusinessAnyWhenFireRuleThenCorrectDiscount()
  {
    Customer customer = new Customer(CustomerType.BUSINESS, 0);
    kieFacadeRemote.fireRules(customer);
    assertEquals(kieFacadeRemote.fireRules(customer), 20);
  }
}
