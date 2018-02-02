FROM gradle:4.1.0-jdk8-alpine as gradlebuilder
COPY build.gradle gradle.properties /app/
LABEL Dockerfile-from=com.toothcloud.api.pma
COPY src/ /app/src/
WORKDIR /app
USER root
RUN gradle build


FROM tomcat:9.0-alpine AS tomcat-test
RUN apk update && apk add bash curl
WORKDIR /usr/local/tomcat/webapps/
RUN rm -rf ROOT
COPY --from=gradlebuilder /app/build/libs/*.war /usr/local/tomcat/webapps/ROOT.war
COPY tomcat-users.xml /usr/local/tomcat/conf/
HEALTHCHECK --interval=1m --timeout=7s --retries=3 \
CMD curl -f http://localhost:8080/rest/pma/health_checkup || exit 1

