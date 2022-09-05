FROM openjdk:17
ADD target/lab1.jar lab1.jar
ENTRYPOINT ["java", "-jar", "lab1.jar"]
EXPOSE 8080