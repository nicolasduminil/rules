# Rules

This project shows how to use Drools, one of the most popular Business Rules Engine, with WebLogic application servers.

Most of the applications implement dozens of business rules based on which validation and other types of controls are performed.

These business rules are often implemented in the Java code and this is a known antipatern because:

- the business rules are known by the business analysts who don't know how to program in Java and, hence, aren't able to implement them by themselves. They need to communicate them to Java developers who implement them further and, during this communication process, errors and inadvertences happen
- the business rules are changing very often and, in order to adapt the application to their changements, Java developers are required
- ideally, business rules should be externalized from the code and expressed in a way accessible to business analysts such then can implement and update them
- The Java code below shows a classical example of a business rule implemented in Java:

```
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
```

The example above uses a domain object which models a customer and, based on different conditions, here the customer's
history, a discount is allowed. This example is one of the most classical.

As shown here, the code might become quite complicated if several `if ... then ... else` structures are embedded.
With Drools, the business rules are externalized from the code and implemented in a formalism usable directly by business
analysts. This formalism may be the DRL (Droll Rule Language) notation, or simply an Excel sheet.

In our example, we use an Excel sheet that any business analysts should be able to provide.

This Excel sheet is used as an input argument of our `KieBuilder` component used in the `KieFacade` class. This class exposes
a local and a remote EJB, each one creating a `KieSession` instance, based on the `KieBuilder` using the Excel sheet as a
business rules repository. The local `KieFacade` is to be used by clients running in the container while the remote one
may be used by clients running outside the container.

In order to fire rules, both `KieFacade` (local and remote) provide the `fireRules` method.

## Building and running the sample

A script named build.sh is provided in order to automatize the build, install and deploy process. This sample being a
WebLogic based one, a local WebLogic Server installation is required. In order to use the build.sh script, you need to
modify its domainHome variable such that to adapt to your environment. Then just execute the script without any parameters
and this should be enough to compile, build, deploy and test.
Enjoy !
