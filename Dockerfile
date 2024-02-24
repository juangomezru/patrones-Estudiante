FROM openjdk:latest

WORKDIR /app

COPY build/libs/estudiante-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]

