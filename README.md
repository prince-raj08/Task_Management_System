# Task Management API – Backend Intern Assignment

## Overview
This project is a **RESTful Task Management API** built using **Java, Spring Boot, and Spring Data JPA**.  
It demonstrates CRUD operations, entity relationships (1:1, 1:N, N:M), validation, and exception handling.

The system allows users to manage **Tasks, Comments, Tags, and Metadata** with proper database relationships.

---

## Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 / MySQL Database
- Maven
- Lombok
- Jackson

---

## Features

### Core Features
- Create Task
- Get All Tasks (with filters)
- Get Task by ID
- Update Task
- Delete Task
- Input Validation
- Custom Exception Handling
- Proper HTTP Status Codes

---

## Entity Relationships

| Relationship | Description |
|-------------|------------|
| **User → Tasks (1:N)** | One user can have multiple tasks |
| **Task → Comments (1:N)** | One task can have many comments |
| **Task ↔ Tags (N:M)** | Tasks and tags are many-to-many |
| **Task → TaskMetadata (1:1)** | Optional metadata for each task |

---

## Entities

### User
- id
- name
- email

### Task
- id
- title
- description
- status (TODO / IN_PROGRESS / COMPLETED)
- createdAt
- updatedAt
- user
- tags
- metadata

### Comment
- id
- text
- createdAt
- user
- task

### Tag
- id
- name

### TaskMetadata
- id
- estimatedHours
- actualHours
- priority

---

## API Endpoints

### Tasks
| Method | Endpoint | Description |
|-------|---------|------------|
POST | `/api/tasks` | Create task |
GET | `/api/tasks` | Get all tasks |
GET | `/api/tasks/{id}` | Get task by ID |
PUT | `/api/tasks/{id}` | Update task |
DELETE | `/api/tasks/{id}` | Delete task |

Filters:



---

### Users
| Method | Endpoint | Description |
|-------|---------|------------|
POST | `/api/users` | Create user |
GET | `/api/users` | Get all users |
GET | `/api/users/{userId}/tasks` | Get tasks of a user |

---

### Comments
| Method | Endpoint | Description |
|-------|---------|------------|
POST | `/api/tasks/{taskId}/comments` | Add comment to task |
GET | `/api/tasks/{taskId}/comments` | Get comments of task |

---

### Tags
| Method | Endpoint | Description |
|-------|---------|------------|
POST | `/api/tags` | Create tag |
GET | `/api/tags` | Get all tags |
POST | `/api/tasks/{taskId}/tags/{tagId}` | Assign tag to task |
DELETE | `/api/tasks/{taskId}/tags/{tagId}` | Remove tag from task |

---

## Sample API Requests

### Create Task
```json
POST /api/tasks
{
  "title": "Complete assignment",
  "description": "Finish backend intern assignment",
  "status": "TODO",
  "userId": 1
}
