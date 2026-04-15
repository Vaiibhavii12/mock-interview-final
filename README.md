# InterviewForge — AI Mock Interview Platform

A full-stack mock interview platform with AI-powered feedback.

## 🏗️ Architecture

- **Frontend**: Vanilla HTML/CSS/JS — deployed on **Vercel**
- **Backend**: Java Spring Boot REST API — deployed on **Railway**
- **Database**: PostgreSQL (Railway add-on) / H2 (local dev)

## 📁 Project Structure

```
├── Mock_Frontend/          # Frontend (HTML, CSS, JS)
│   ├── index.html
│   ├── style.css
│   └── script.js
├── Mock_Backend/           # Spring Boot Backend
│   ├── pom.xml
│   ├── Dockerfile
│   ├── Procfile
│   └── src/main/java/com/interviewforge/
│       ├── controller/     # REST Controllers
│       ├── model/          # JPA Entities
│       ├── dto/            # Data Transfer Objects
│       ├── repository/     # Spring Data Repositories
│       ├── service/        # Business Logic
│       ├── security/       # JWT Auth
│       └── config/         # CORS, Security Config
```

## 🚀 API Endpoints

| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| POST | `/api/auth/signup` | ❌ | Register new user |
| POST | `/api/auth/login` | ❌ | Login & get JWT |
| GET | `/api/questions?domain=X` | ❌ | Get questions |
| GET | `/api/leaderboard` | ❌ | Top performers |
| POST | `/api/interviews/start` | ✅ | Start interview |
| POST | `/api/interviews/{id}/answer` | ✅ | Submit answer |
| POST | `/api/interviews/{id}/end` | ✅ | End & get results |
| GET | `/api/users/me` | ✅ | User profile |
| GET | `/api/users/me/history` | ✅ | Interview history |

## 🛠️ Local Development

### Backend
```bash
cd Mock_Backend
mvn spring-boot:run
```
Backend runs at `http://localhost:8080`

### Frontend
Open `Mock_Frontend/index.html` with Live Server or any static file server.

## 🌐 Deployment

### Frontend (Vercel)
- Connect this repo to Vercel
- Set root directory to `Mock_Frontend`
- Framework: Other (static)

### Backend (Railway)
- Connect this repo to Railway
- Set root directory to `Mock_Backend`
- Add PostgreSQL plugin
- Set environment variables:
  - `DATABASE_URL` — from Railway PostgreSQL
  - `DATABASE_USERNAME` — from Railway PostgreSQL
  - `DATABASE_PASSWORD` — from Railway PostgreSQL
  - `DATABASE_DRIVER` = `org.postgresql.Driver`
  - `HIBERNATE_DIALECT` = `org.hibernate.dialect.PostgreSQLDialect`
  - `JWT_SECRET` — your secret key (min 32 chars)
  - `CORS_ORIGINS` — your Vercel frontend URL
  - `H2_CONSOLE` = `false`

## 👩‍💻 Built By
**Vaibhavi Dushetwar**
