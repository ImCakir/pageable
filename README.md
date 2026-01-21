Pageable Project

📌 What is this project?

- This project is a Spring Boot REST API example that shows how to:
•	Use pagination with Spring Data JPA
•	Centralize pagination and sorting logic
•	Convert Entity objects to DTOs
•	Return a standard API response structure

The goal is to write clean, reusable, and understandable backend code.

---

🧠 Main Idea (In Simple Words)

- Instead of writing pagination code again and again in every controller:
•	Pagination logic is written once
•	Controllers reuse this logic
•	Responses always have the same format

---

- 🧱 Project Structure

```java
Controller
↓
BaseController   (shared logic)
↓
Service
↓
Repository (Spring Data JPA)
```

---

📌 Pagination Flow

1️⃣ Client sends request with page info in URL

Example:

```java
GET /rest/api/personel/list/pageable?pageNumber=0&pageSize=5&columnName=id&asc=true
```

2️⃣ Spring maps URL parameters to RestPageableRequest

3️⃣ PagerUtil converts this request to Pageable

4️⃣ Repository returns a Page<Personel>

5️⃣ Entity list is converted to DTO list

6️⃣ Result is returned as a standard response

---

📦 Important Classes

1️⃣ RestPageableRequest

Represents pagination information coming from the URL.

```java
pageNumber  → which page
pageSize    → how many records
columnName  → sort field
asc         → ascending / descending
```

---

2️⃣ PagerUtil

Utility class that creates a Pageable object.

- What it does:
•	Adds sorting only if columnName is provided
•	Supports ASC / DESC sorting

---

3️⃣ BaseController

Parent controller class.

- Why it exists:
•	Avoid code duplication
•	Share pagination & response logic

public Pageable toPageable(RestPageableRequest request)

---

4️⃣ Page vs Pageable

| pageable   | page |
| --- | --- |
| request info  | result data |
| page number | content list |
| page size   |   total elements |


---

5️⃣ DTO Usage

Entities are not sent directly to the client.

Instead:
•	Entity → DTO
•	Safer and cleaner API

---

6️⃣ RestPageableEntity

Standard pagination response model.

Contains:
•	content (DTO list)
•	pageNumber
•	pageSize
•	totalElements

---

7️⃣ RestRootEntity

Wraps every API response.

status       → HTTP status code
payload      → actual data
errorMessage → message info

---

📌 Example Response (Simplified)

```json
{
"status": 200,
"errorMessage": "OK",
"payload": {
"content": [...],
"pageNumber": 0,
"pageSize": 5,
"totalElements": 42
}
}
```

---

🎯 Why This Project is Important
•	Shows real backend pagination usage
•	Uses clean architecture
•	Easy to extend
•	Suitable for CV & interviews

---

🚀 Technologies Used
•	Java
•	Spring Boot
•	Spring Data JPA
•	Lombok

---

📌 Summary

This project focuses on how pagination should be designed properly in a backend application:
•	Clean
•	Reusable
•	Understandable
