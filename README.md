<<<<<<< HEAD
# Game App SDP (Spring Boot + MongoDB Atlas)

A Spring Boot REST API backed by MongoDB for managing games, members, collections (daily cash collections), admin users, and transactions. Controllers use DTOs for requests/responses and map via a shared `DtoMapper`.

## Tech Stack
- Java 21
- Spring Boot
- MongoDB Atlas
- Maven
=======
# Game App SDP (Spring Boot + MongoDB + React)

A full-stack application with Spring Boot REST API backed by MongoDB for managing games, members, collections (daily cash collections), admin users, and transactions, plus a React frontend for user interaction.

## Tech Stack

### Backend
- Java 21
- Spring Boot 3.3.4
- Spring Data MongoDB
- Maven

### Frontend
- React 18
- React Router DOM
- Axios for API communication
- Modern CSS styling
>>>>>>> 8d68aff (added frontend)

## Getting Started

1) Configure MongoDB
- Edit `src/main/resources/application.properties`:
```
spring.data.mongodb.uri=mongodb+srv://<user>:<pass>@<cluster>/<params>
spring.data.mongodb.database=game_app_sdp
<<<<<<< HEAD
```

2) Build
```
./mvnw clean package
```

3) Run
```
./mvnw spring-boot:run
```
The API runs at `http://localhost:8080`.

## Docker (optional)
```
docker build -t game-app-sdp .
docker run --rm -p 8080:8080 -e SPRING_DATA_MONGODB_URI="<your_mongo_uri>" -e SPRING_DATA_MONGODB_DATABASE=game_app_sdp game-app-sdp
```

=======
```

2) Build
```
./mvnw clean package
```

3) Run
```
./mvnw spring-boot:run
```
The API runs at `http://localhost:8080`.

## Frontend Setup

1) Navigate to the frontend directory:
```bash
cd frontend
```

2) Install dependencies:
```bash
npm install
```

3) Start the React development server:
```bash
npm start
```

The frontend will be available at `http://localhost:3000`.

### Quick Start (Windows)
Run the provided batch files:
- `setup-frontend.bat` - Sets up the frontend structure
- `start-frontend.bat` - Installs dependencies and starts the frontend

### Frontend Features
- **Games Management**: Add, edit, and manage your game catalog
- **Member Management**: Track member information and balances  
- **Transaction Tracking**: Record and monitor all game transactions
- **Collections**: Track daily cash collections with total calculations
- **Admin Users**: Manage administrative access
- **Responsive Design**: Modern, mobile-friendly interface
- **Real-time Updates**: Automatic data refresh after operations

## Docker (optional)
```
docker build -t game-app-sdp .
docker run --rm -p 8080:8080 -e SPRING_DATA_MONGODB_URI="<your_mongo_uri>" -e SPRING_DATA_MONGODB_DATABASE=game_app_sdp game-app-sdp
```

>>>>>>> 8d68aff (added frontend)
## API Overview (DTO-based)
All endpoints accept and return DTOs. IDs are Mongo ObjectId strings.

### Games `/games`
- POST `/games`
- GET `/games`
- GET `/games/{id}`
- PUT `/games/{id}`
- DELETE `/games/{id}`

GameDto
```
{
  "id": "",
  "name": "FIFA 25",
  "description": "Football",
  "price": 59.99
}
```

### Members `/members`
- POST `/members`
- GET `/members`
- GET `/members/{id}`
- PUT `/members/{id}`
- DELETE `/members/{id}`

MemberDto
```
{
  "id": "",
  "name": "Alex",
  "balance": 0.0,
  "phone": "+1-555-0100"
}
```

### Collections `/collections`
`date` defaults to now if missing.
- POST `/collections`
- GET `/collections`
- GET `/collections/{id}`
- PUT `/collections/{id}`
- DELETE `/collections/{id}`

CollectionEntryDto
```
{
  "id": "",
  "date": "2025-09-18T10:00:00.000+00:00",
  "amount": 250.0
}
```

### Admin Users `/admin-users`
`username` is unique.
- POST `/admin-users`
- GET `/admin-users`
- GET `/admin-users/{id}`
- PUT `/admin-users/{id}`
- DELETE `/admin-users/{id}`

AdminUserDto
```
{
  "id": "",
  "username": "admin",
  "password": "secret"
}
```

### Transactions `/transactions`
References `members` and `games`. `dateTime` defaults to now if missing.
- POST `/transactions`
- GET `/transactions`
- GET `/transactions/{id}`
- GET `/transactions/member/{memberId}`
- GET `/transactions/game/{gameId}`
- PUT `/transactions/{id}`
- DELETE `/transactions/{id}`

TransactionDto
```
{
  "id": "",
  "memberId": "<memberObjectId>",
  "gameId": "<gameObjectId>",
  "amount": 99.0,
  "dateTime": "2025-09-18T10:30:00.000+00:00"
}
```

## Error Handling
Global handler returns:
- 400 Bad Request: `BusinessException`
- 404 Not Found: `IdNotPresentException`, `CollectionNotFoundException`, `AdminUserNotFoundException`, `TransactionNotFoundException`

## Notes
- DTOs: `com.sakalesh.game_app_sdp.dto`
- Mapper: `DtoMapper` converts entity <-> DTO
- Unique index on `admin_users.username` via `@Indexed(unique = true)`
<<<<<<< HEAD
=======

## Project Structure
```
game_app_sdp/
├── src/                          # Spring Boot backend
│   ├── main/java/com/sakalesh/game_app_sdp/
│   │   ├── controller/           # REST controllers
│   │   ├── dto/                  # Data Transfer Objects
│   │   ├── modal/                # MongoDB entities
│   │   ├── repository/           # MongoDB repositories
│   │   ├── services/             # Business logic
│   │   └── exceptions/           # Custom exceptions
│   └── main/resources/
│       └── application.properties
├── frontend/                     # React frontend
│   ├── src/
│   │   ├── components/           # React components
│   │   ├── services/             # API service layer
│   │   └── App.js               # Main App component
│   ├── public/
│   └── package.json
├── pom.xml                       # Maven configuration
├── Dockerfile
└── README.md
```

## Tests

### Backend Tests
```bash
./mvnw test
```

### Frontend Tests
```bash
cd frontend
npm test
```

## Development Workflow
npm create vite@latest client

1. Start MongoDB (or use MongoDB Atlas)
2. Start the Spring Boot backend: `./mvnw spring-boot:run`
3. Start the React frontend: `cd frontend && npm start`
4. Access the application at `http://localhost:3000`
5. The frontend will automatically proxy API requests to the backend

## Production Build

### Backend
```bash
./mvnw clean package
java -jar target/game_app_sdp-0.0.1-SNAPSHOT.jar
```

### Frontend
```bash
cd frontend
npm run build
# Serve the build folder with a web server
```
>>>>>>> 8d68aff (added frontend)
