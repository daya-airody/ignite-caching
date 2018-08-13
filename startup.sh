#!/bin/bash

export JAVA_OPTS="-Xms512m -Xmx2048m -Duser.timezone=America/Los_Angeles -DSERVER_NAME=localhost -Dhibernate.show_sql=false"
java $JAVA_OPTS  -Djava.util.logging.config.file=./logging.properties -jar target/partnertap-cache.jar --spring.config.location=classpath:/application.properties
