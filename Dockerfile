FROM openjdk:21-jdk-oracle

COPY target/CompanyEmployeeRest-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
