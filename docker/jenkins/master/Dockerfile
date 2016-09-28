#------------------------------------------------------------------------------
# Set the base image for subsequent instructions:
#------------------------------------------------------------------------------

FROM jenkins:alpine

MAINTAINER Daniel Ibáñez Fernández <me@e-dani.com>

#------------------------------------------------------------------------------
# Set Number of Executors , Slave And Security Password
#------------------------------------------------------------------------------

COPY *.groovy /usr/share/jenkins/ref/init.groovy.d/

#------------------------------------------------------------------------------
# Add Init script to set password variables and plugins
#------------------------------------------------------------------------------

ADD ./rootfs /

CMD ["/init"]