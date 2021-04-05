# SpringBoot-Assignment

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

# Database

It uses a H2 in memory database (for now), can be changed easily in the `application.properties` for any other database.

#Swagger
 
 http://localhost:8080/swagger-ui.html
 
 for test the application from swagger you need to generate jwt token.
 
 # How to generate JWT
 
 from postman make a post request on url : localhost:8080/authenticate
 
 with request body 
 {
    "username": "Test",
    "password": "password"
}

after recieving token append it with String "Bearer" like this
"Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZXN0IiwiZXhwIjoxNjE3NTE2MzQxLCJpYXQiOjE2MTc0OTgzNDF9.YphNG-txN2C25OdC6Tu-UoDibgdWLC5s7-UBdiYVD3b00SXw-piq_Gg08LN4-T1JFfvVTnK276lCfXhjCXK9Vw"

And after you click on Autthrize botton on swagger-ui console put the whole jwt in value field.
 
