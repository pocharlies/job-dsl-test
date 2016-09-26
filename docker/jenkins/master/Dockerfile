#------------------------------------------------------------------------------
# Set the base image for subsequent instructions:
#------------------------------------------------------------------------------

FROM jenkins:alpine

MAINTAINER Daniel Ibáñez Fernández <me@e-dani.com>

#------------------------------------------------------------------------------
# Install plugins:
#------------------------------------------------------------------------------

RUN /usr/local/bin/install-plugins.sh \
    groovy \
    disk-usage \
    ssh-credentials \
    credentials \
    job-dsl \
    javadoc \
    junit \
    gradle \
    ssh-slaves \
    cloudbees-folder \
    test-results-analyzer \
    build-pipeline-plugin \
    git \
    github \
    pipeline-stage-view \
    github-organization-folder \
    workflow-aggregator

#------------------------------------------------------------------------------
# Set Number of Executors and Slave
#------------------------------------------------------------------------------

COPY *.groovy /usr/share/jenkins/ref/init.groovy.d/