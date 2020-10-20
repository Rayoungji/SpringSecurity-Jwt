FROM openjdk:8
COPY build/libs/*.jar spring_security_practice.jar
ENTRYPOINT ["java", "-jar", "spring_security_practice.jar"]