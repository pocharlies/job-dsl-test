FROM ubuntu

RUN apt-get update && apt-get -y install bash git openssh-server default-jdk groovy gradle \
    && ssh-keygen -A \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/* \
    && adduser --disabled-password --gecos "" jenkins \
    && echo "jenkins:jenkins" | chpasswd

RUN mkdir /var/run/sshd \
    && chmod 0755 /var/run/sshd

EXPOSE 22

CMD ["/usr/sbin/sshd", "-D"]