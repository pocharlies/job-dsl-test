String basePath = "2-scripting"
String repo = 'pocharlies/job-dsl-test'

folder(basePath) {
    description 'CI folder of jobslsimitspace'
}


job("$basePath/clean-Workspaces") {
    label('master')
    scm {
        github repo
    }
    steps {
        systemGroovyCommand(readFileFromWorkspace('jobs/scripting/scripts/cleanWorkspaces.groovy'))
    }
}