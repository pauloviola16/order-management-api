FROM eclipse-temurin:21
LABEL maintainer="pcviola.dev@gmail.com"
WORKDIR /app
COPY target/order-management-api-0.0.1-SNAPSHOT.jar /app/aplicacao-docker.jar
ENTRYPOINT ["java", "-jar", "aplicacao-docker.jar"]
