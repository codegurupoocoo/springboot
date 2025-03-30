# Spring Boot Assignment

## 📌 Overview
This project is a Spring Boot-based application developed as part of the Software Development Engineer Internship assignment for Pinggy. The application follows industry best practices and demonstrates proficiency in backend development with Java Spring Boot.

## 🛠️ Technologies Used
- **Spring Boot** (Java Backend Framework)
- **Maven** (Dependency Management)
- **Spring Data JPA** (Database ORM)
- **H2/MySQL/PostgreSQL** (Database, configurable)
- **Spring Boot REST API**
- **Swagger/OpenAPI** (API Documentation)

## 🚀 Features
- CRUD operations for managing resources.
- RESTful API endpoints with proper request handling.
- Database integration with JPA/Hibernate.
- Exception handling and validation.
- Unit testing (JUnit & Mockito).

## 📂 Project Structure
```
├── src/main/java/com/example/project
│   ├── controller  # API Controllers
│   ├── service     # Business Logic
│   ├── repository  # Data Access Layer
│   ├── model       # Entity Definitions
│   ├── config      # Configuration Classes
│   ├── exceptions  # Error Handling
├── src/main/resources
│   ├── application.properties  # Configurations
│   ├── data.sql  # Sample Data
├── pom.xml  # Maven Dependencies
└── README.md  # Project Documentation
```

## 🏗️ Setup & Installation
### Prerequisites:
- **Java 17+**
- **Maven Installed** (`mvn -version` to check)
- **MySQL/PostgreSQL (optional, if using a DB other than H2)`**

### Steps:
1. **Clone the Repository**
   ```sh
   git clone https://github.com/codegurupoocoo/springboot.git
   cd springboot
   ```
2. **Build the Project**
   ```sh
   mvn clean install
   ```
3. **Run the Application**
   ```sh
   mvn spring-boot:run
   ```
4. **API Documentation (Swagger UI)**
   - Open browser and go to: `http://localhost:8080/swagger-ui.html`

## 📝 API Endpoints
| Method | Endpoint | Description |
|--------|----------|------------|
| GET    | `/api/resources` | Fetch all resources |
| GET    | `/api/resources/{id}` | Fetch a single resource |
| POST   | `/api/resources` | Create a new resource |
| PUT    | `/api/resources/{id}` | Update a resource |
| DELETE | `/api/resources/{id}` | Delete a resource |

## ⚠️ Known Issues
- If `mvn spring-boot:run` fails, ensure that the correct Java version is installed.
- Database credentials should be updated in `application.properties` before running the app.

## ✨ Contribution & Contact
- **Tushar Singh**
- **Email:** tusharsingh1616@gmail.com
- **GitHub:** [codegurupoocoo](https://github.com/codegurupoocoo)

Feel free to fork, modify, or raise issues! 🚀

