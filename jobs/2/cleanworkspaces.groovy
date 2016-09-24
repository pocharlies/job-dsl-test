String basePath = "2-10jobslimitspace"
String repo = 'pocharlies/job-dsl-test'

folder(basePath) {
    description 'King test CI folder of jobslsimitspace'
}


job("$basePath/clean-Workspaces") {
    label('master')
    scm {
        github repo
    }
    steps {
        systemGroovyCommand(readFileFromWorkspace('jobs/2/scripts/cleanWorkspaces.groovy'))
    }
}