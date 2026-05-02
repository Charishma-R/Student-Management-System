package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student s) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "INSERT INTO students (name, email, phone, course, marks) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhone());
            ps.setString(4, s.getCourse());
            ps.setDouble(5, s.getMarks());
            ps.executeUpdate();
            System.out.println("Student Added Successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // VIEW ALL STUDENTS
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("course"),
                    rs.getDouble("marks")
                );
                s.setId(rs.getInt("id"));
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }

    // UPDATE STUDENT
    public void updateStudent(int id, double newMarks) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "UPDATE students SET marks=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, newMarks);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Student Updated Successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student Deleted Successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
 // SEARCH BY ID
    public Student searchById(int id) {
        Student s = null;
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = new Student(
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("course"),
                    rs.getDouble("marks")
                );
                s.setId(rs.getInt("id"));
            } else {
                System.out.println("No student found with ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return s;
    }

    // SEARCH BY NAME
    public List<Student> searchByName(String name) {
        List<Student> list = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM students WHERE name LIKE ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("course"),
                    rs.getDouble("marks")
                );
                s.setId(rs.getInt("id"));
                list.add(s);
            }
            if (list.isEmpty()) {
                System.out.println("No student found with name: " + name);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }
    
 // UPDATE NAME
    public void updateName(int id, String newName) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "UPDATE students SET name=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newName);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Name Updated Successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE EMAIL
    public void updateEmail(int id, String newEmail) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "UPDATE students SET email=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newEmail);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Email Updated Successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE PHONE
    public void updatePhone(int id, String newPhone) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "UPDATE students SET phone=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newPhone);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Phone Updated Successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE COURSE
    public void updateCourse(int id, String newCourse) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "UPDATE students SET course=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newCourse);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Course Updated Successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}