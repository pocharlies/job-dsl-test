String home = "/tmp"
String basePath = '1-configuration'
String repo = 'pocharlies/web-hello-world'
GString customWorkspacePath = "${home}/workspaces/${basePath}"


folder(basePath) {
    description 'King test CI folder of web-hello-world'
}

job("$basePath/web-hello-world-build") {
    customWorkspace(customWorkspacePath.toString())
    jdk('Java8')
    scm {
        github repo
    }
    label('slave')
    triggers {
        scm 'H/5 * * * *'
    }
    steps {
        gradle {
            fromRootBuildScriptDir false
            useWrapper true
            tasks 'clean test'
        }
    }
    publishers {
        archiveJunit 'build/test-results/**/*.xml'
        downstream('1-configuration/web-hello-world-archive', 'SUCCESS')
    }
}