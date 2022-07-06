FROM openjdk:11-jre-slim
EXPOSE 8081
WORKDIR /app
COPY target/challenge-slingr-math-security-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "challenge-slingr-math-security-0.0.1-SNAPSHOT.jar" ]