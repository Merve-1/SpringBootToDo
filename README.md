## 📌 Project Structure

### **Backend: Spring Boot**
- RESTful API built with Spring Boot.
- Uses **Spring Data JPA** with MySQL as the database.
- Provides CRUD operations for managing ToDo tasks.
- CORS enabled to allow frontend interaction.

### **Frontend: Angular**
- Built using **Angular 15+** with standalone components.
- Uses **provideHttpClient()** for API requests.
- Bootstrap for styling.
- Displays, creates, updates, and deletes tasks via the UI.

---

## 🚀 Getting Started

### **1. Clone the Repository**
```sh
git clone https://github.com/Merve-1/StringBootToDo
cd SpringBootToDo
```

### **2. Backend Setup (Spring Boot)**
#### **Prerequisites:**
- Java 17+
- MySQL Database
- Maven

#### **Steps:**
1. Navigate to the `backend` folder.
```sh
cd ToDo
```
2. Configure MySQL database in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=yourpassword
```
3. Run the Spring Boot application:
```sh
mvn spring-boot:run
```
4. MySQL Database:
![image](https://github.com/user-attachments/assets/2ad4c8d5-44f5-4127-b8dd-5f14a5b31228)


---

### **3. Frontend Setup (Angular)**
#### **Prerequisites:**
- Node.js (LTS version)
- Angular CLI

#### **Steps:**
1. Navigate to the `frontend` folder:
```sh
cd ToDoFront
```
2. Install dependencies:
```sh
npm install
```
3. Start the Angular application:
```sh
ng serve
```
4. Open **http://localhost:4200/** in the browser.

---

## 🔥 API Endpoints

| Method | Endpoint | Description |
|--------|----------|--------------|
| **GET** | `/api/viewToDoList` | Get all ToDo tasks |
| **GET** | `/api/getToDoItem/{id}` | Get a ToDo task by ID |
| **POST** | `/api/saveToDoItem` | Create a new ToDo task |
| **PUT** | `/api/updateToDoStatus/{id}` | Update ToDo status to "Completed" |
| **PUT** | `/api/editToDoItem` | Edit an existing ToDo task |
| **DELETE** | `/api/deleteToDoItem/{id}` | Delete a ToDo task |

---

## 🛠️ Testing API with Postman

1. Open **Postman**.
2. Import the **API collection** (if available) or create new requests.
3. Use the API endpoints listed above.
4. For POST and PUT requests, send **JSON data** in the request body, e.g.:
```json
{
  "title": "Complete Angular project",
  "date": "2.25-03-02"
  "status": "Pending"
}
```

5. Verify responses and update API calls as needed.
  ```json

   Successfully saved

  ```

   ![image](https://github.com/user-attachments/assets/1eef7e33-c366-4666-8a7d-8d0a15b85a32)
   ![image](https://github.com/user-attachments/assets/4febb172-7809-4a4c-8366-3c14f8290521)
   
  ---
## 🎨 UI Preview (Angular Frontend)
The Angular frontend provides a user-friendly interface to interact with the ToDo API. Users can:
- Add new tasks.
- View all tasks.
- Update the status of tasks.
- Edit or delete tasks.

  ![image](https://github.com/user-attachments/assets/951b6f00-35da-421b-a88b-b9912521e534)
---

## ⚡ Technologies Used
### **Backend:**
- Java 17
- Spring Boot 3.4.3
- Spring Data JPA
- MySQL
- Maven

### **Frontend:**
- Angular 19+
- TypeScript
- Bootstrap

---

