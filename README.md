# insights
insights dashboard

## Spring Boot, PostgreSQL, JPA, Hibernate REST API for Insights Dashboard

## Tutorial

Check out the complete tutorial on the CalliCoder blog -

[Spring Boot, PostgreSQL, JPA, Hibernate RESTful CRUD API Example](https://www.callicoder.com/spring-boot-jpa-hibernate-postgresql-restful-crud-api-example/)

## Steps to Setup

**1. Clone the repository**

```bash
git clone https://github.com/callicoder/spring-boot-postgresql-jpa-hibernate-rest-api-demo.git
```

**2. Configure PostgreSQL**

First, create a database named `postgres_demo`. Then, open `src/main/resources/application.properties` file and change the spring datasource username and password as per your PostgreSQL installation.
Run the sql file under in `src/main/resources/sql directory to have the default db values
**3. Run the app**

Type the following command from the root directory of the project to run it -

```bash
mvn spring-boot:run
```
the application is built and available in port 8081 for access.You can use the Postman collection within the resources folder 

Alternatively, you can package the application in the form of a WAR file and then run it like so -

```bash
mvn clean package
insight/target/insight-0.0.1-SNAPSHOT

https://www.baeldung.com/tomcat-deploy-war

