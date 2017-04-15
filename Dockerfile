FROM java:8
EXPOSE 9000
ADD /target/SpringDocker.jar SpringDocker.jar
ENTRYPOINT ["java","-jar","SpringDocker.jar"]