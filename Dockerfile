FROM azul/zulu-openjdk-alpine:17
ARG JAR_FILE=target/*.jar
COPY ./target/auth-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080 8000
ENTRYPOINT ["java", "-jar", "/app.jar"]
