#------------------------------------------------------------------------------
# Set the base image for subsequent instructions:
#------------------------------------------------------------------------------

FROM jenkins:alpine

MAINTAINER Daniel Ibáñez Fernández <me@e-dani.com>

#------------------------------------------------------------------------------
# Install plugins:
#------------------------------------------------------------------------------

COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt