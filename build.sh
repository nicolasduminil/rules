export domainHome=/home/nicolas/oracle/wls1411/user_projects/domains/base_domain/
#
# Build a clean archive vy skipping unit tests execution
#
#
echo ">>> build.sh: Building a clean archive by skipping unit tests execution"
mvn -DskipTests clean install > /dev/null
#
# If WebLogic Server isn't running already then start it
#
echo ">>> build.sh: Done"
ps=$(ps -ef)
if echo $ps | grep -q weblogic
then
  :
else
  echo ">>> build.sh: Starting WebLogic Server"
  mvn com.oracle.weblogic:weblogic-maven-plugin:start-server -DdomainHome=${domainHome} > /dev/null
  echo ">>> build.sh: Done"
fi
#
# If the rules-manager application is already deployed then undeploy it
#
apps=$(mvn com.oracle.weblogic:weblogic-maven-plugin:list-apps)
if echo $apps | grep -q "There is no application to list"
then
  :
else
  echo ">>> build.sh: Undeploying the rules-manager.war application"
  mvn com.oracle.weblogic:weblogic-maven-plugin:undeploy > /dev/null
  echo ">>> build.sh: Done"
fi
#
# Deploy the rules-manager application
#
echo ">>> build.sh: Deploying the rules-manager.war application"
mvn com.oracle.weblogic:weblogic-maven-plugin:deploy > /dev/null
echo ">>> build.sh: Done"
#
# Run unit tests
#
echo ">>> build.sh: Running the unit tests"
mvn test
echo ">>> build.sh: Done"

#
# Undeploy rules-manager application
#
echo ">>> Undeploying the rules-manager.war application"
mvn com.oracle.weblogic:weblogic-maven-plugin:undeploy > /dev/null
echo ">>> build.sh: Done"
#
# Stop WebLogic Server
#
echo ">>> build.sh: Stopping WebLogic Server"
mvn com.oracle.weblogic:weblogic-maven-plugin:stop-server -DdomainHome=${domainHome} > /dev/null
echo ">>> build.sh: Done"

