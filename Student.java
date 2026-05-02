package com.student;

public class Student {
    
    private int id;
    private String name;
    private String email;
    private String phone;
    private String course;
    private double marks;
    
    // Constructor
    public Student(String name, String email, String phone, String course, double marks) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.marks = marks;
    }
    
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }
    
    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setCourse(String course) { this.course = course; }
    public void setMarks(double marks) { this.marks = marks; }
}