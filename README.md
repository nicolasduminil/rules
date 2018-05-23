This project shows how to use Drools, one of the most popular Business Rules Engine, with WebLogic application servers.

#Required dependencies:

<dependency>
  <groupId>org.drools</groupId>
  <artifactId>drools-compiler</artifactId>
  <version>7.5.0.Final</version>
</dependency>
<dependency>
  <groupId>org.drools</groupId>
  <artifactId>drools-decisiontables</artifactId>
  <version>7.5.0.Final</version>
</dependency>
<dependency>
  <groupId>org.kie</groupId>
  <artifactId>kie-ci</artifactId>
  <version>7.5.0.Final</version>
</dependency>

#Deploy, run and test
cd rules                                             #move to the home directory
mvn –DskipTests clean install                        #build the WAR file while skipping the test phase
mvn com.oracle.weblogic:weblogic-maven-plugin:deploy #deploy the WAR file on the local WebLogic server
mvn test                                             #run the unit test
