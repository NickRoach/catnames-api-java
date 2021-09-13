FROM openjdk:8
ADD target/catnames-api.jar catnames-api.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "catnames-api.jar"]