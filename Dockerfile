FROM openjdk:19
EXPOSE 8080
ADD /target/credit-project.jar credit-project.jar
ENTRYPOINT ["java", "-jar", "/credit-project.jar"]