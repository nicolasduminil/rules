This project shows how to use Drools, one of the most popular Business Rules Engine, with WebLogic application servers.

#Required dependencies:

<br/><dependency>  
<br/>  <groupId>org.drools</groupId>  
<br/>  <artifactId>drools-compiler</artifactId>  
<br/>  <version>7.5.0.Final</version>  
<br/></dependency>  
<br/><dependency>  
<br/>  <groupId>org.drools</groupId>  
<br/>  <artifactId>drools-decisiontables</artifactId>  
<br/>  <version>7.5.0.Final</version>  
<br/></dependency>  
<br/><dependency>  
<br/>  <groupId>org.kie</groupId>  
<br/>  <artifactId>kie-ci</artifactId>  
<br/>  <version>7.5.0.Final</version>  
<br/></dependency>  

#Deploy, run and test  
cd rules                                             #move to the home directory  
mvn –DskipTests clean install                        #build the WAR file while skipping the test phase  
mvn com.oracle.weblogic:weblogic-maven-plugin:deploy #deploy the WAR file on the local WebLogic server  
mvn test                                             #run the unit test  e
