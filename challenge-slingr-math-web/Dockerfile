FROM openjdk:11-jre-slim
EXPOSE 8080
WORKDIR /app
COPY target/challenge-slingr-math-web-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "challenge-slingr-math-web-0.0.1-SNAPSHOT.jar" ]