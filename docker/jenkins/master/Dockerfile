#------------------------------------------------------------------------------
# Set the base image for subsequent instructions:
#------------------------------------------------------------------------------

FROM jenkins

MAINTAINER Daniel Ibáñez Fernández <me@e-dani.com>

USER root

#------------------------------------------------------------------------------
# Install plugins:
#------------------------------------------------------------------------------

COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

#------------------------------------------------------------------------------
# Install dependencies in groovy to execute AddSShNodeToJenkins
#------------------------------------------------------------------------------

RUN apt-get update && apt-get install -y groovy bsdmainutils && apt-get clean

#------------------------------------------------------------------------------
# Set Number of Executors and Slave
#------------------------------------------------------------------------------

COPY *.groovy /usr/share/jenkins/ref/init.groovy.d/

USER jenkins
