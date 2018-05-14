# Spring-boot-app-Shipwerk
Hi, This is spring boot application built on spring boot and angular 1.4

# Pre instalation:
* install mysql database called 'shipwreck' and run it on mysql server:
```
spring.datasource.url=jdbc:mysql://localhost:3306/shipwreck
spring.datasource.username=springboot
spring.datasource.password=1234
```
* columns for shipwreck table could be found in https://github.com/Arkhypov/Spring-boot-app-Shipwreck/blob/master/src/main/resources/db/migration/V2__create_shipwreck.sql
* run `mvn clean install`
* run app `mvn spring-boot:run`. App is running on http://localhost:8181/index.html#/
* add at least 1 shipwreck to pass integration tests
