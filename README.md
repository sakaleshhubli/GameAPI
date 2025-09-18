
# GameAPI

A Spring Boot implementation of a gaming-related API.

---

## Table of Contents

- [About](#about)  
- [Features](#features)  
- [Technology Stack](#technology-stack)  
- [Getting Started](#getting-started)  
  - [Prerequisites](#prerequisites)  
  - [Setup](#setup)  
  - [Running](#running)  
- [API Endpoints](#api-endpoints)  
- [Configuration](#configuration)  
- [Docker](#docker)  
- [Contributing](#contributing)  

---

## About

GameAPI is a backend service built using Spring Boot. It provides endpoints for managing games and related operations.  
The project follows a clean structure with standard conventions, aimed at being easy to understand, test, and extend.

---

## Features

- RESTful API endpoints for CRUD operations on games  
- Uses Spring Boot framework  
- Containerization support via Docker  
- Build tool: Maven  
- Environment configuration managed via properties files  

---

## Technology Stack

| Component       | Version / Details |
|-----------------|-------------------|
| Language        | Java |
| Framework       | Spring Boot |
| Build Tool      | Maven |
| Containerization| Docker |
| Utilities       | Maven Wrapper, Spring Config |

---

## Getting Started

### Prerequisites

Make sure you have installed:

- Java (JDK 21 or higher recommended)  
- Maven  
- Docker (if you want to use containers)

### Setup

1. Clone the repository  
   ```bash
   git clone https://github.com/sakaleshhubli/GameAPI.git
   cd GameAPI


2. Build the project using Maven

   ```bash
   mvn clean install
   ```

### Running

* To run locally:

  ```bash
  mvn spring-boot:run
  ```

* Or, package into a jar and run:

  ```bash
  mvn package
  java -jar target/GameAPI-<version>.jar
  ```

---

## API Endpoints

| HTTP Method | Path          | Description                   |
| ----------- | ------------- | ----------------------------- |
| `GET`       | `/games`      | List all games                |
| `GET`       | `/games/{id}` | Get details for a single game |
| `POST`      | `/games`      | Create a new game             |
| `PUT`       | `/games/{id}` | Update an existing game       |
| `DELETE`    | `/games/{id}` | Delete a game                 |
| `GET`       | `/members `      | List all members                |
| `GET`       | `/members /{id}` | Get details for a single game |
| `POST`      | `/members`      | Create a new game             |
| `PUT`       | `/members/{id}` | Update an existing game       |
| `DELETE`    | `/members/{id}` | Delete a game                 |


---

## Configuration

Configuration files (e.g. `application.properties` or `application.yml`) allow you to set up things like:

* Server port
* Database connection (if applicable)
* Logging levels

Environment-specific overrides are encouraged (e.g. for dev vs production).

---

## Docker

A `Dockerfile` is included so you can containerize the application.

To build the Docker image:

```bash
docker build -t gameapi:latest .
```

To run the container:

```bash
docker run -p 8080:8080 gameapi:latest
```

---

## Contributing

Thank you for your interest in contributing!

1. Fork the repository
2. Create a feature branch

   ```bash
   git checkout -b feat/YourFeature
   ```
3. Commit your changes

   ```bash
   git commit -m "Add some feature"
   ```
4. Push to your fork

   ```bash
   git push origin feat/YourFeature
   ```
5. Open a pull request

Please ensure your code follows standard formatting/style and is well-tested.

```

