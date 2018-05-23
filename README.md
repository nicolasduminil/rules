This project shows how to use Drools, one of the most popular Business Rules Engine, with WebLogic application servers.

#Required dependencies:

<dependency  
  <groupIdorg.drools</groupId  
  <artifactIddrools-compiler</artifactId  
  <version7.5.0.Final</version  
</dependency  
<dependency  
  <groupIdorg.drools</groupId  
  <artifactIddrools-decisiontables</artifactId  
  <version7.5.0.Final</version  
</dependency  
<dependency  
  <groupIdorg.kie</groupId  
  <artifactIdkie-ci</artifactId  
  <version7.5.0.Final</version  
</dependency

#Deploy, run and test  
cd rules                                             #move to the home directory  
mvn –DskipTests clean install                        #build the WAR file while skipping the test phase  
mvn com.oracle.weblogic:weblogic-maven-plugin:deploy #deploy the WAR file on the local WebLogic server  
mvn test                                             #run the unit test  e
