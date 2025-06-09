# Virtual Machine API

REST API developed with **Java 17 + Spring Boot**, responsible for managing virtual machines. It offers complete **registration**, **query**, **update** and **removal** (CRUD) operations for VMs, with support for persistence in relational databases.

---

## Technologies Used

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- Spring Web
- Hibernate
- PostgreSQL
- Maven
- Swagger (OpenAPI)
- Lombok
- JUnit
- Mockito

---

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development purposes.

## Prerequisites

Before running the project, you need to have installed:

- Java 17+
- Maven 3.8+
- PostgreSQL 12+

---

## Environment Configuration

This project uses environment variables to store sensitive information.

the src/main/resources/application.properties file of your Spring Boot project, add:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/my-database
spring.datasource.username=my-user
spring.datasource.password=my-password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```


