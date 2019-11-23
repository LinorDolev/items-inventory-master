FROM openjdk:8-jdk-alpine
VOLUME  C:/Users/Linor/Desktop/linor/Projects/items-inventory-master/items-inventory-master
ARG JAR_FILE=build/libs/inventory-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]



