String basePath = 'web-hello-world-ci'
String repo = 'pocharlies/web-hello-world'

folder(basePath) {
    description 'King test CI folder of web-hello-world'
}

job("$basePath/web-hello-world-build") {
    scm {
        github repo
    }
    triggers {
        scm 'H/5 * * * *'
    }
    steps {
        gradle {
            useWrapper true
            tasks 'clean test'
        }
    }
    publishers {
        archiveJunit 'build/test-results/**/*.xml'
    }
}

job("$basePath/web-hello-world-deploy") {
    parameters {
        stringParam 'host'
    }
    steps {
        shell 'scp war file; restart...'
    }
}