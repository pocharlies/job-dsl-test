String basePath = "2-10jobslimitspace"
String repo = 'pocharlies/job-dsl-test'

folder(basePath) {
    description 'King test CI folder of jobslsimitspace'
}

job("$basePath/generate-bulk-data") {
    label('slave')
    scm {
        github repo
    }
    steps {
        systemGroovyCommand(readFileFromWorkspace('jobs/2/scripts/cleanWorkspaces.groovy'))
    }
}