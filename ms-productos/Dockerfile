FROM eclipse-temurin:17-jre-alpine

EXPOSE 8001

WORKDIR /root

COPY ./target/ms-productos-0.0.1-SNAPSHOT.jar /root/ms-productos-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/root/ms-productos-0.0.1-SNAPSHOT.jar"]
