import hudson.model.*

cleanWorkspacesJobs(Hudson.instance.items)

def cleanWorkspacesJobs(items) {
    for (item in items) {
        if (item.class.canonicalName == 'com.cloudbees.hudson.plugins.folder.Folder') {
            cleanWorkspacesJobs(((com.cloudbees.hudson.plugins.folder.Folder) item).getItems())
        } else if (item.class.canonicalName != 'org.jenkinsci.plugins.workflow.job.WorkflowJob') {
            if(!item.isBuilding()) {
                println("Wiping out workspace of job "+item.name)
                item.doDoWipeOutWorkspace()
            }
        }
    }
}