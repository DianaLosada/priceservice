FROM openjdk:21
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/priceservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} price.jar
ENTRYPOINT ["java","-jar","/price.jar"]