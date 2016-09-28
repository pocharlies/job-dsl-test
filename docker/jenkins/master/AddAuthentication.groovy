import jenkins.model.*
import hudson.security.*

String bindName = System.getenv("USER_JENKINS")
String bindPassword = System.getenv("PASS_JENKINS")

def instance = Jenkins.getInstance()

hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(bindName,bindPassword)
instance.setSecurityRealm(hudsonRealm)
instance.save()

strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)