FROM eclipse-temurin:17-jdk-jammy
# VOLUME /var/log/bo-platform
ARG JAR_FILE=usermanagement-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]