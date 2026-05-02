# Student Management System

A console-based CRUD application built using Core Java, JDBC and MySQL 
to manage student records efficiently.

## Technologies Used
- Core Java
- JDBC
- MySQL
- Eclipse IDE

## Features
- Add Student
- View All Students
- Update Student Details (Name, Email, Phone, Course, Marks)
- Delete Student
- Search Student by ID
- Search Student by Name
- Menu Driven Program

## Database Setup
CREATE DATABASE student_management;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    course VARCHAR(50),
    marks DOUBLE
);

## How to Run
1. Create MySQL database using above SQL commands
2. Update your MySQL password in DatabaseConnection.java
3. Add MySQL connector JAR to build path
4. Run Main.java as Java Application
