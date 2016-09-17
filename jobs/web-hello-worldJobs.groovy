String basePath = 'web-hello-world-ci'
String repo = 'pocharlies/job-dsl-test'

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
        gradle 'clean test'
        dsl {
            external 'jobs/**/*Jobs.groovy'
            additionalClasspath 'src/main/groovy'
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