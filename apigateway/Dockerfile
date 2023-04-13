FROM openjdk:17-slim
COPY target/apigatewayservice-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
