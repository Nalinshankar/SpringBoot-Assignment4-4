# SpringBoot-Assignment

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)


# Database

It uses a H2 in memory database (for now), can be changed easily in the `application.properties` for any other database.

# How to use this code?

1. Make sure you have [Java 8](https://www.java.com/download/) and [Maven](https://maven.apache.org) installed

2. Fork this repository and clone it
  
```
$ git clone https://github.com/Nalinshankar/SpringBoot-Assignment4-4
```

3. Navigate into the folder  

```
$ cd SpringBoot-Assignment4-4
```

4. Install dependencies

```
$ mvn install
```

5. Run the project

```
$ mvn spring-boot:run
```

6. Navigate to `http://localhost:8080/swagger-ui.html` in your browser to check everything is working correctly. You can change the default port in the `application.yml` file

```yml
server:
  port: 8080
```

7. Make a POST request to user controller `/users/signin` with the default admin user we programatically created to get a valid JWT token.you can use the admin or client users (password: admin and client respectively)

```
$ curl -X POST 'http://localhost:8080/users/signin?username=admin&password=admin'
```

8. Once you have successfully logged in and obtained the token, you should click on the right top button Authorize and introduce it with the prefix "Bearer " 
9. Now you can test all the apis defined
