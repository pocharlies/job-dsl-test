FROM alpine

RUN apk --update --no-cache add bash git openssh openjdk8 \
    && ssh-keygen -A \
    && rm -rf /var/cache/apk/* \
    && adduser -D jenkins \
    && echo "jenkins:jenkins" | chpasswd

EXPOSE 22

CMD ["/usr/sbin/sshd", "-D"]