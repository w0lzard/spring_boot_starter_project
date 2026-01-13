# 🚀 Spring Boot Crash Course

A modern REST API built with **Kotlin**, **Spring Boot**, and **MongoDB** featuring JWT authentication and secure note management.

---

## ✨ Features

- 🔐 **JWT Authentication** - Secure user registration and login
- 📝 **Note Management** - Create, read, update, and delete notes
- 🗄️ **MongoDB Integration** - Reactive database operations
- 🛡️ **Spring Security** - Protected endpoints with role-based access
- ⚡ **Reactive Programming** - Non-blocking I/O with Project Reactor
- 🎯 **Kotlin-First** - Modern, expressive, and type-safe

---

## 🛠️ Tech Stack

| Technology | Version |
|------------|---------|
| **Kotlin** | 1.9.25 |
| **Spring Boot** | 3.4.3 |
| **Java** | 17 |
| **MongoDB** | Reactive Driver |
| **JWT (JJWT)** | 0.12.6 |
| **Gradle** | Kotlin DSL |

---

## 📦 Dependencies

- `spring-boot-starter-web` - REST API framework
- `spring-boot-starter-data-mongodb-reactive` - Reactive MongoDB support
- `spring-boot-starter-security` - Authentication & authorization
- `spring-boot-starter-validation` - Input validation
- `jjwt-api` - JSON Web Token implementation
- `kotlinx-coroutines-reactor` - Coroutines support

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- MongoDB instance running locally or remotely
- Gradle (wrapper included)

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd spring_boot_crash_course
   ```

2. **Configure MongoDB**

   Update `src/main/resources/application.properties` with your MongoDB connection string:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/your-database
   ```

3. **Build the project**
   ```bash
   ./gradlew build
   ```

4. **Run the application**
   ```bash
   ./gradlew bootRun
   ```

The API will be available at `http://localhost:8080`

---

## 📚 API Endpoints

### Authentication

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/auth/register` | Register a new user |
| `POST` | `/api/auth/login` | Login and receive JWT token |

### Notes

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| `GET` | `/api/notes` | Get all notes | ✅ |
| `GET` | `/api/notes/{id}` | Get note by ID | ✅ |
| `POST` | `/api/notes` | Create a new note | ✅ |
| `PUT` | `/api/notes/{id}` | Update a note | ✅ |
| `DELETE` | `/api/notes/{id}` | Delete a note | ✅ |

---

## 🔑 Authentication Flow

1. **Register** a new user via `/api/auth/register`
2. **Login** with credentials to receive a JWT token
3. **Include** the JWT token in the `Authorization` header:
   ```
   Authorization: Bearer <your-jwt-token>
   ```
4. **Access** protected endpoints with the token

---

## 🏗️ Project Structure

```
src/main/kotlin/com/ryuken/spring_boot_crash_course/
├── controllers/          # REST API endpoints
├── database/
│   └── repository/      # MongoDB repositories
├── model/               # Data models (User, Note)
├── security/            # JWT & authentication logic
│   ├── AuthService.kt
│   ├── JWTService.kt
│   ├── JWTAuthFilter.kt
│   ├── SecurityConfig.kt
│   └── HashEncoder.kt
└── SpringBootCrashCourseApplication.kt
```

---

## 🧪 Testing

Run the test suite:

```bash
./gradlew test
```

---

## 📝 License

This project is part of a Spring Boot crash course tutorial.

---

## 👨‍💻 Author

Built with ❤️ using Kotlin and Spring Boot

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

---

## 📞 Support

For questions or support, please open an issue in the repository.
