FROM openjdk:8-jre-alpine
ENV LANG C.UTF-8
ENV LANG zh_CN.UTF-8
ENV LC_ALL zh_CN.UTF-8
ENV TZ=Asia/Shanghai
WORKDIR /
ADD ./target/ynkf-websocket-1.0.0.jar app.jar
ADD ./src/main/resources/application.yml application.yml
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","-c","application.yml"]
