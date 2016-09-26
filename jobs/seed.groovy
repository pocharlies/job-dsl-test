String repo = 'pocharlies/job-dsl-test'

job('seed') {
    scm {
        github repo
    }
    label('slave')
    triggers {
        scm 'H/5 * * * *'
    }
    steps {
        gradle 'clean test'
        dsl {
            external 'jobs/**/*Jobs.groovy'
            additionalClasspath 'src/main/groovy'
        }
        dsl {
            external 'pipelines/**/*Pipelines.groovy'
            additionalClasspath 'src/main/groovy'
        }
    }
    publishers {
        archiveJunit 'build/test-results/**/*.xml'
    }
}