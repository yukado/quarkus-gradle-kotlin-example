# Showcase Monolith: Quarkus + Kotlin + Vue

A fullstack showcase project with **Quarkus (Kotlin)** as backend and **Vue.js** as frontend.  
Goal: Clean architecture with Entities, Repositories, REST Resources, and JWT Security.

---

## 🚀 Features

- **Backend (Quarkus/Kotlin)**
    - Entities: `User`, `Product`, `Order`
    - Repositories with typical query functions
    - REST Resources (`GET`, `POST`)
    - JWT authentication with roles
    - OpenAPI + Swagger UI documentation

- **Frontend (Vue.js)**
    - Vue Router for navigation
    - Axios for API calls
    - Views for User, Product, Order
    - JWT login and token handling

---

## 🛠️ Tech Stack

- **Backend:** Quarkus, Kotlin, Panache, Hibernate ORM, PostgreSQL
- **Frontend:** Vue 3, Vite, Axios, Pinia (state management)
- **Security:** SmallRye JWT
- **Docs:** Swagger UI, OpenAPI
- **Containerization:** Docker, Docker Compose

---

## ⚙️ Setup

### 1. Start Backend
```bash
./gradlew build
docker-compose up --build
```
Backend runs at: 👉 http://localhost:8080

Swagger UI: 👉 http://localhost:8080/swagger
### 2. Start Frontend
```bash
cd frontend
npm install
npm run dev
```
Frontend runs at: 👉 http://localhost:5173
---
🔑 Example API Calls
- `POST /users` →
Create User
- POST http://localhost:8080/users
  Content-Type: application/json

{
"email": "test@example.com",
"username": "tester",
"roles": ["user"]
}
- Create product
- POST http://localhost:8080/products
  Content-Type: application/json
{
"name": "Laptop",
"description": "High-end developer machine",
"price": 1999.99,
"currency": "EUR",
"tags": ["hardware", "dev"],
"available": true
}
---
## 🧩 Architecture
src/main/kotlin/dev/yukado/quarkus/
\\\
├── model/        # Entities
├── repository/   # Repositories
├── resource/     # REST Controllers
├── service/      # Business logic (e.g. JwtService)
└── Application.kt # Main class
\\\
---
📜 License
This project is a showcase and demo. Author: Yusuf Kagan Dogruyol (yukado)

---

✅ This README is now fully in English and ready to present your project professionally.

Would you like me to also add a **section for Docker deployment** (with `docker-compose` instructions) so the README is self-contained for anyone who wants to run it?

