FROM openjdk:21-jdk-oracle
WORKDIR /app
COPY /target/MyJavaSite-0.0.1-SNAPSHOT.jar /app/bmwsite.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bmwsite.jar"]