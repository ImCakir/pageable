Pageable Project

📌 What is this project?

- This project is a Spring Boot REST API example that shows how to:
1.	Use pagination with Spring Data JPA
2.	Centralize pagination and sorting logic
3.  Convert Entity objects to DTOs
4.	Return a standard API response structure

The goal is to write clean, reusable, and understandable backend code.

---

🧠 Main Idea 

- Instead of writing pagination code again and again in every controller:
1.	Pagination logic is written once
2.	Controllers reuse this logic
3.  Responses always have the same format

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
1.	Adds sorting only if columnName is provided
2.	Supports ASC / DESC sorting

---

3️⃣ BaseController

Parent controller class.

- Why it exists:
1.	Avoid code duplication
2.	Share pagination & response logic

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
1.	Entity → DTO
2.	Safer and cleaner API

---

6️⃣ RestPageableEntity

Standard pagination response model.

Contains:
1.	content (DTO list)
2.	pageNumber
3.	pageSize
4.	totalElements

---

7️⃣ RestRootEntity

Wraps every API response.

```json
status       → HTTP status code
payload      → actual data
errorMessage → message info
```

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
1.	Shows real backend pagination usage
2.	Uses clean architecture
3.	Easy to extend
4.	Suitable for CV & interviews

---

🚀 Technologies Used
1.	Java
2.	Spring Boot
3.	Spring Data JPA
4.	Lombok

---

📌 Summary

This project focuses on how pagination should be designed properly in a backend application:
1.	Clean
2.	Reusable
3.	Understandable
