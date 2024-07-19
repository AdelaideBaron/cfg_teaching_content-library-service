FROM eclipse-temurin:21-jdk
WORKDIR /src
COPY target/library-service-0.0.1-SNAPSHOT.jar /src/library-service.jar
# (for above) -> go to jar file-> right click -> copy path/reference -> from content root
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "library-service.jar"]