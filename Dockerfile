FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/covid19SpainApi-1.0.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/covid19SpainApi-1.0.jar /opt/app/covid19SpainApi.jar
COPY ${JAR_FILE} covid19SpainApi.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=pro","-jar","covid19SpainApi.jar"]