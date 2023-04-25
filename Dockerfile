FROM openjdk:11
LABEL authors="Hamhabocca"
ARG JAR_FILE=build/libs/Dallibocca-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]