FROM tomcat:9.0

COPY target/aston_simple_app.war /usr/local/tomcat/webapps

CMD ["catalina.sh", "run"]
