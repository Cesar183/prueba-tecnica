FROM eclipse-temurin:17-jre-alpine

EXPOSE 8002

WORKDIR /root

COPY ./target/ms-invetario-0.0.1-SNAPSHOT.jar /root/ms-invetario-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/root/ms-invetario-0.0.1-SNAPSHOT.jar"]
