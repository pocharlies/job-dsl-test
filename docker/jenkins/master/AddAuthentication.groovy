import jenkins.model.*
import hudson.security.*

String bindName = 'admin'
String bindPassword = 'admin'

def instance = Jenkins.getInstance()

hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(bindName,bindPassword)
instance.setSecurityRealm(hudsonRealm)
instance.save()

strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)