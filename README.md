# 🎓 Student Management System (Java Servlet + JDBC)

## 📌 Overview

This is a simple **Student Management System** built using **Java Servlets, JDBC, and MySQL**.
It allows an admin to manage student records with full CRUD operations and a login system.

---

## 🚀 Features

* 🔐 Login Authentication (Session-based)
* ➕ Add Student
* 📋 View Students
* ✏️ Edit Student
* ❌ Delete Student
* 🚪 Logout Functionality
* 🏠 Central Dashboard (Home Page)

---

## 🛠️ Tech Stack

* **Java (Servlets)**
* **JDBC**
* **MySQL**
* **Apache Tomcat**
* **HTML & CSS**

---

## 📂 Project Structure

```
src/
 └── main/
     ├── java/
     │   └── org.example/
     │       ├── AddStudentServlet.java
     │       ├── DeleteStudentServlet.java
     │       ├── EditStudentServlet.java
     │       ├── UpdateStudentServlet.java
     │       ├── ViewStudentsServlet.java
     │       ├── LoginServlet.java
     │       ├── LogoutServlet.java
     │       ├── HomeServlet.java
     │       └── DBConnection.java
     │
     └── webapp/
         ├── login.html
         ├── addStudent.html
         ├── index.html
         └── style.css
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository

```
git clone https://github.com/your-username/student-management-system.git
```

### 2️⃣ Import into IDE

* Open in IntelliJ / Eclipse
* Configure Apache Tomcat

### 3️⃣ Setup MySQL Database

Create database:

```sql
CREATE DATABASE student_db;
USE student_db;
```

Create tables:

```sql
CREATE TABLE users (
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO users (username, password)
VALUES ('admin', 'admin123');
```

```sql
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    email VARCHAR(100),
    course VARCHAR(100)
);
```

---

### 4️⃣ Configure Database Connection

Update `DBConnection.java`:

```java
String url = "jdbc:mysql://localhost:3306/student_db";
String user = "root";
String password = "your_password";
```

---

### 5️⃣ Run the Project

* Start Tomcat server
* Open browser:

```
http://localhost:8080/
```

---

## 🔑 Default Login

```
Username: admin
Password: 1234
```

---

## 📸 Screenshots (Optional but Recommended)

*Add screenshots here for better presentation*

* Login Page
* Dashboard
* Student List

---

## 📈 Future Improvements

* 🔍 Search functionality
* 📊 Dashboard analytics (total students)
* 🔐 Password encryption
* 🎨 Improved UI (Bootstrap)

---

## 🙌 Author

**Saksham Agarwal**

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
