# Case Program - REST API (Spring Boot) Test

## Overview
Case Program is a REST API built with Spring Boot that manages legal cases. It provides endpoints for creating, retrieving, listing, and deleting case records.

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Jakarta Persistence API (JPA)
- Lombok
- Maven
- H2 (in-memory database)

## Project Structure
```
├── src/main/java/com/example/demo
│   ├── controllers  # Contains REST controllers
│   ├── domain       # Contains entity models
│   ├── repositories # Data access layer (Spring Data JPA)
│   ├── services     # Business logic layer
│   ├── constants    # Enums and constants
│
├── src/main/resources
│   ├── application.properties # Configuration file
│
├── mvnw # Maven wrapper
├── pom.xml # Maven dependencies
```

## API Endpoints

### Create or Update a Case
**PUT** `/case/{id}`
```json
{
  "id": "1",
  "fileNumber": "1234",
  "caseTitle": "Legal Dispute",
  "caseNumber": 5678,
  "caseStatus": "OPEN",
  "kindOfCase": "Civil",
  "courtCase": "Supreme Court",
  "engagedDate": "2023-01-01T10:00:00Z",
  "location": "New York",
  "clientName": "John Doe"
}
```
**Response:** `201 Created`

---

### Retrieve a Case by ID
**GET** `/case/{id}`

**Response:**
```json
{
  "id": "1",
  "fileNumber": "1234",
  "caseTitle": "Legal Dispute",
  "caseNumber": 5678,
  "caseStatus": "OPEN",
  "kindOfCase": "Civil",
  "courtCase": "Supreme Court",
  "engagedDate": "2023-01-01T10:00:00Z",
  "location": "New York",
  "clientName": "John Doe"
}
```

---

### List All Cases
**GET** `/case`

**Response:**
```json
[
  {
    "id": "1",
    "fileNumber": "1234",
    "caseTitle": "Legal Dispute",
    "caseNumber": 5678,
    "caseStatus": "OPEN",
    "kindOfCase": "Civil",
    "courtCase": "Supreme Court",
    "engagedDate": "2023-01-01T10:00:00Z",
    "location": "New York",
    "clientName": "John Doe"
  }
]
```

---

### Delete a Case
**DELETE** `/case/{id}`

**Response:** `204 No Content`

## Running the Application

### Prerequisites
- Java 17+
- Maven
- Postman or any API testing tool (optional)

### Steps to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/JisuKayl/CaseProgram-RestAPI-Springboot.git
   cd CaseProgram-RestAPI-Springboot
   ```
2. Run the application using Maven:
   ```sh
   ./mvnw spring-boot:run
   ```
3. The API will be available at: `http://localhost:8080/case`

## Testing the API
Use Postman or any API testing tool to interact with the endpoints.

## License
This project is licensed under the MIT License.

## Sample Output:
![image](https://github.com/user-attachments/assets/eea90a1f-3354-4183-a384-af63671c27ee)
