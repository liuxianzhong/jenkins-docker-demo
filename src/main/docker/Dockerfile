FROM openjdk:8-jdk-alpine
ADD *.jar app.jar
ENV JAVA_OPTS="\
-Xms256m \
-Xmx512m \
--Xss1024K \
-XX:PermSize=128m \
-XX:MaxPermSize=256m" 
ENTRYPOINT ["java","${JAVA_OPTS}","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
