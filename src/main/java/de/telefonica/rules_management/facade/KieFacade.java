package de.telefonica.rules_management.facade;

import javax.annotation.*;
import javax.ejb.*;

import org.kie.api.*;
import org.kie.api.builder.*;
import org.kie.api.runtime.*;
import org.kie.api.runtime.rule.*;
import org.kie.internal.io.*;

import de.telefonica.rules_management.facts.*;

@Stateless
public class KieFacade implements KieFacadeLocal, KieFacadeRemote
{
  private KieSession kieSession;
  
  @PostConstruct
  public void init()
  {
    KieServices kieServices = KieServices.Factory.get();
    KieBuilder kieBuilder = kieServices.newKieBuilder(kieServices.newKieFileSystem().write(ResourceFactory.newClassPathResource("de/telefonica/drools/rules/Discount.xls", getClass())));
    kieBuilder.buildAll();
    kieSession = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId()).newKieSession();
  }

  public int fireRules(Customer customer)
  {
    FactHandle fact = kieSession.insert(customer);
    kieSession.fireAllRules();
    kieSession.delete(fact);
    return customer.getDiscount();
  }
  
  @PreDestroy
  public void destroy()
  {
    kieSession.destroy();
    kieSession.dispose();
  }
}
