package com.student;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Search Student by Name");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    Student s = new Student(name, email, phone, course, marks);
                    dao.addStudent(s);
                    break;

                case 2:
                    System.out.println("\n--- All Students ---");
                    List<Student> list = dao.getAllStudents();
                    if (list.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        for (Student st : list) {
                            System.out.println("ID: " + st.getId() +
                                    " | Name: " + st.getName() +
                                    " | Email: " + st.getEmail() +
                                    " | Phone: " + st.getPhone() +
                                    " | Course: " + st.getCourse() +
                                    " | Marks: " + st.getMarks());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();
                    int updateChoice;
                    do {
                        System.out.println("\n===== Update Student =====");
                        System.out.println("1. Update Name");
                        System.out.println("2. Update Email");
                        System.out.println("3. Update Phone");
                        System.out.println("4. Update Course");
                        System.out.println("5. Update Marks");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        updateChoice = sc.nextInt();

                        switch (updateChoice) {
                            case 1:
                                sc.nextLine();
                                System.out.print("Enter New Name: ");
                                String newName = sc.nextLine();
                                dao.updateName(updateId, newName);
                                break;
                            case 2:
                                sc.nextLine();
                                System.out.print("Enter New Email: ");
                                String newEmail = sc.nextLine();
                                dao.updateEmail(updateId, newEmail);
                                break;
                            case 3:
                                sc.nextLine();
                                System.out.print("Enter New Phone: ");
                                String newPhone = sc.nextLine();
                                dao.updatePhone(updateId, newPhone);
                                break;
                            case 4:
                                sc.nextLine();
                                System.out.print("Enter New Course: ");
                                String newCourse = sc.nextLine();
                                dao.updateCourse(updateId, newCourse);
                                break;
                            case 5:
                                System.out.print("Enter New Marks: ");
                                double updatedMarks = sc.nextDouble();
                                dao.updateStudent(updateId, updatedMarks);
                                break;
                            case 6:
                                System.out.println("Going back to Main Menu!");
                                break;
                            default:
                                System.out.println("Invalid choice! Please enter 1-6");
                        }
                    } while (updateChoice != 6);
                    break;

                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();
                    Student found = dao.searchById(searchId);
                    if (found != null) {
                        System.out.println("\n--- Student Found ---");
                        System.out.println("ID: " + found.getId() +
                                " | Name: " + found.getName() +
                                " | Email: " + found.getEmail() +
                                " | Phone: " + found.getPhone() +
                                " | Course: " + found.getCourse() +
                                " | Marks: " + found.getMarks());
                    }
                    break;

                case 6:
                    sc.nextLine();
                    System.out.print("Enter Student Name to Search: ");
                    String searchName = sc.nextLine();
                    List<Student> searchList = dao.searchByName(searchName);
                    if (!searchList.isEmpty()) {
                        System.out.println("\n--- Students Found ---");
                        for (Student st : searchList) {
                            System.out.println("ID: " + st.getId() +
                                    " | Name: " + st.getName() +
                                    " | Email: " + st.getEmail() +
                                    " | Phone: " + st.getPhone() +
                                    " | Course: " + st.getCourse() +
                                    " | Marks: " + st.getMarks());
                        }
                    }
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-7");
            }

        } while (choice != 7);

        sc.close();
    }
}