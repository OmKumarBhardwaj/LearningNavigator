
# Learning Navigator

## Introduction
Learning Navigator is a RESTful API service crafted using Spring Boot, designed to manage the exam enrollment process within a Learning Management System (LMS). It efficiently integrates with MySQL for reliable data persistence, ensuring seamless handling of student registrations, subject enrollments, and exam management.


## Features
- **CRUD Operations**: Manages create, read, update, and delete operations for Students, Subjects, and Exams.
- **Data Integrity** : Ensures relational integrity with foreign key relationships between students, subjects, and exams.
- **Easter Egg Feature** : A hidden endpoint providing random facts about numbers as an engaging easter egg.
- **Error Handling:** Includes validation for fields and handles common HTTP errors.


## Endpoints
- `GET /users`: Retrieve all registered users.
- `GET /users/{userId}`: Retrieve details of a specific user.
- `POST /users`: Register a new user.
- `PUT /users/{userId}`: Update the score of a specific user.
- `DELETE /users/{userId}`: Deregister a specific user.

## Requirements
- Java JDK 17
- Spring Boot 3.2.4
- MySQL (8 or above)
- Maven (3.9.3 or above)

#### Note : Install all the requirements before running the        project  

## Setup
To run this project locally :- 

**Step 1** - Create a database in Mysql workBench

```
$ CREATE DATABASE learning_navigator;
```

**Step 2** - Run the commands in project root directory
```
$ mvn clean
$ mvn install
$ mvn spring-boot:run
```

## Documentation
Further documentation is available in the code comments and JavaDoc format.

## Postman Collection

Enhance your experience with our API by utilizing the provided Postman collection. This collection is specifically designed to simplify interacting with the API's endpoints, offering a seamless way to test and explore its functionalities.

🔗 **Download the Postman Collection:** Access the collection directly from our repository - simply look for the file named `Learning_Navigator.postman_collection.json`. This file contains pre-configured requests for all the endpoints, making it easier for you to get started with testing and integrating the API into your projects.

## Acknowledgements

- [Java JDK 17 Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [MongoDB Documentation](https://www.mongodb.com/docs/manual/)
- [Maven Documentation](https://maven.apache.org/guides/index.html)
- [REST API Best Practices](https://restfulapi.net/)
- [Global Exception Handling in Spring Boot](https://www.baeldung.com/exception-handling-for-rest-with-spring)
- [Writing Effective READMEs](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)

