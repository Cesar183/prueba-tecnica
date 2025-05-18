FROM eclipse-temurin:17-jre-alpine

EXPOSE 8001

WORKDIR /app/ms-invetario

COPY ./pom.xml /app
COPY ./ms-invetario .

RUN ./

ENTRYPOINT ["java", "-jar", "/root/ms-productos-0.0.1-SNAPSHOT.jar"]
