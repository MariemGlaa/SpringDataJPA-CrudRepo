FROM adoptopenjdk/openjdk11:alpine-jre
RUN apk update
RUN apk add curl 
RUN curl -u admin:nexus -o achat-1.0.jar "http://localhost:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
