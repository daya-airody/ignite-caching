1) Change default port by updating ignite.bat. Add below parameter to java invocation.
-DIGNITE_JETTY_PORT=9080
2) Run as administrator
ignite.bat %IGNITE_HOME%/examples/config/example-cache.xml
3) connect to your postgresql database and run below sql script
scripts/setup_db.sql
4) Build the application
mvn clean install
5) Run the application
./startup.sh
6) Access below URL: 
http://localhost:8080/canned/samplerepslist?managerId=100
First time, it works.
Second time also, it works.

In this case, we are caching an object we created within the service method call.
7) Access below URL:
http://localhost:8080/canned/allrepslist?managerId=100
First time, it works.
Try again. it fails with exception related to proxy method invocation.
In this case, we are caching an object returned by spring JPA.
I have tested both using ConcurrentMapCache. I am able to retrieve objects returned by spring JPA from the cache correctly.
Looks like Ignite is not handling objects returned by spring JPA correctly.
