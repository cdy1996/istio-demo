FROM openjdk:8u212-jre

MAINTAINER cdy chendongyi_1996@163.com

VOLUME /logs

ADD istio-demo-0.0.1-SNAPSHOT.jar istio-demo.jar

RUN bash -c 'touch /istio-demo.jar'

#ENV spring.profiles.active="test"

EXPOSE 8088

ENTRYPOINT ["java", "-jar", "istio-demo.jar"]
