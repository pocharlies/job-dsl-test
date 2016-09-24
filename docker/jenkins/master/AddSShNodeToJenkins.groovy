/**
 * This script is a method to add a slave ssh agent to jenkins
 *
 */
import jenkins.model.*
import hudson.model.*
import hudson.slaves.*
import hudson.plugins.sshslaves.SSHLauncher


// The "build" object is added by the Jenkins Groovy plugin and can resolve parameters and such
String credentialID = 'jenkins'
String agentName = 'slave'
String agentDescription = 'Slave'
String agentIP = 'slave'

// Other parameters are just hard coded for now, adjust as needed
String agentHome = "/home/jenkins"
String agentExecutors = 3
String agentLabels = "slave"

// There is a constructor that also takes a list of properties (env vars) at the end, but haven't needed that yet
DumbSlave dumb = new DumbSlave(agentName, // Agent name, usually matches the host computer's machine name
        agentDescription, // Agent description
        agentHome, // Workspace on the agent's computer
        agentExecutors, // Number of executors
        Node.Mode.NORMAL, // "Usage" field, EXCLUSIVE is "only tied to node", NORMAL is "any"
        agentLabels, // Labels
        new SSHLauncher(agentIP, 22, credentialID, "jenkins", "", "", "", "", ""),
        RetentionStrategy.INSTANCE, // Is the "Availability" field and INSTANCE means "Always"
        new LinkedList())

Jenkins.instance.addNode(dumb)

println "Agent '$agentName' created with $agentExecutors executors and home '$agentHome'"

Jenkins.instance.nodes.each {
    println "AFTER - Agent: $it"
}