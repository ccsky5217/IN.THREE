FROM maven:3-jdk-8-alpine

MAINTAINER CC.SKY "hui.2.zhu@nokia-sbell.com"

WORKDIR /code

ENV host 0.0.0.0

ADD pom.xml /code/pom.xml
ADD src /code/src
#ADD settings.xml /root/.m2/settings.xml

RUN ["mvn", "package"]

EXPOSE 707

ENTRYPOINT ["/usr/lib/jvm/java-1.8-openjdk/bin/java", "-cp", "target/lib/*:target/docker-restful-demo-1.0-SNAPSHOT.jar","org.jmotor.INmemberInfoMicroServices"]
#ENTRYPOINT ["/usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java", "-cp", "target/lib/*:target/docker-restful-demo-1.0-SNAPSHOT.jar","org.jmotor.INmemberInfoMicroServices"]

CMD ["-Djava.awt.headless=true"]
