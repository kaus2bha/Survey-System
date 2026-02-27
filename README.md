# Survey System Backend

A secure and scalable Survey Management System built using **Spring Boot**, implementing **JWT-based authentication** and **Role-Based Access Control (RBAC)**.

This backend application allows administrators to create and manage surveys while enabling users to securely participate and submit responses.

---

## 🚀 Features

### 🔐 Authentication & Authorization
- User Registration & Login
- JWT-based stateless authentication
- Role-based access control (ADMIN / USER)
- Secured REST APIs using Spring Security

### 👨‍💼 Admin Capabilities
- Create surveys
- Add questions to surveys
- Add options to questions
- Activate/Deactivate surveys

### 👤 User Capabilities
- Fetch active surveys
- View survey questions with options
- Submit responses securely
- Prevent unauthorized access

### 🗄 Database & Persistence
- MySQL database integration
- JPA/Hibernate ORM
- Relational mapping:
   User → Survey → Question → Option → UserResponse

  
---

## 🛠 Tech Stack

- **Java**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Token)**
- **MySQL**
- **JPA / Hibernate**
- **Maven**

---

## 📂 Project Structure

    src/main/java/com/abis/survay_system
    │
    ├── config → Security configuration & JWT filter
    ├── controller → REST API controllers
    ├── service → Business logic layer
    ├── repository → JPA repositories
    ├── model → Entity classes
    ├── dto → Request/Response DTOs
    └── util → JWT utility classes


---

## 🔑 API Endpoints

### 🔐 Authentication
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register new user |
| POST | `/api/auth/login` | Authenticate and receive JWT |

---

### 👨‍💼 Admin APIs (Requires ADMIN Role)
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/admin/surveys` | Create new survey |
| POST | `/api/admin/questions` | Add question to survey |
| POST | `/api/admin/options` | Add option to question |

---

### 👤 User APIs (Requires USER Role)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/user/surveys/{id}` | Fetch survey details |
| POST | `/api/user/surveys/{id}/submit` | Submit survey responses |

---

🗃 Database Schema Overview

Core tables:
  -users
  -surveys
  -questions
  -options
  -user_response
  
#Relationships:
  -One user can submit multiple responses
  -One survey contains multiple questions
  -One question contains multiple options
  -Each submission is stored in user_response

🔒 Security Highlights
  -Stateless authentication using JWT
  -Role-based route protection
  -Secure password hashing using BCrypt
  -Protected admin endpoints

🔒 Security Highlights
  -Stateless authentication using JWT
  -Role-based route protection
  -Secure password hashing using BCrypt
  -Protected admin endpoints


    ⚙️ How To Run Locally
    1️⃣ Clone Repository
        git clone https://github.com/kaus2bha/Survey-System.git
    
    2️⃣ Configure Database
        Create MySQL database:
        CREATE DATABASE survey_system;

    Update application.properties:
      spring.datasource.username=your_db_username
      spring.datasource.password=your_db_password
      jwt.secret=your_secret_key

    3️⃣ Run Application
      mvn spring-boot:run
      or
      ./mvnw spring-boot:run

    Application runs on:
      http://localhost:8080

  
👨‍💻 Author
  -Kaustubh Mali
  -Backend Developer | Java & Spring Boot Enthusiast
