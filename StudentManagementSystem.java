package codeSoftIntershipTasks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student 
{
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) 
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nRoll Number: " + rollNumber + "\nGrade: " + grade + "\n";
    }
}

class StudentManagement 
{
    private List<Student> students;

    public StudentManagement() 
    {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void saveStudentDataToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
            }
            System.out.println("STUDENT DATA SAVED TO " + filename);
        } catch (IOException e) {
            System.out.println("ERROR SAVING STUDENT DATA TO FILE: " + e.getMessage());
        }
    }

    public void loadStudentDataFromFile(String filename) {
        students.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int rollNumber = Integer.parseInt(parts[1]);
                    String grade = parts[2];
                    students.add(new Student(name, rollNumber, grade));
                }
            }
            System.out.println("STUDENT DATA LOADED FROM " + filename);
        } catch (IOException e) {
            System.out.println("ERROR LOADING STUDENT DATA FROM FILE: " + e.getMessage());
        }
    }
}

public class StudentManagementSystem 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement system = new StudentManagement();

        while (true) {
            System.out.println("STUDENT MANAGEMENT SYSTEM");
            System.out.println("1. ADD STUDENT");
            System.out.println("2. REMOVE STUDENT");
            System.out.println("3. SEARCH STUDENT");
            System.out.println("4. DISPLAY ALL STUDENTS");
            System.out.println("5. SAVE STUDENT DATA");
            System.out.println("6. LOAD STUDENT DATA");
            System.out.println("7. EXIT");
            System.out.print("SELECT AN OPTION: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 1:
                    System.out.print("ENTER STUDENT NAME: ");
                    String name = scanner.nextLine();
                    System.out.print("ENTER ROLL NUMBER: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("ENTER GRADE: ");
                    String grade = scanner.nextLine();
                    system.addStudent(new Student(name, rollNumber, grade));
                    break;
                case 2:
                    System.out.print("ENTER ROLL NUMBER OF STUDENT TO REMOVE: ");
                    int rollNumberToRemove = scanner.nextInt();
                    system.removeStudent(rollNumberToRemove);
                    break;
                case 3:
                    System.out.print("ENTER ROLL NUMBER OF STUDENT TO SEARCH: ");
                    int rollNumberToSearch = scanner.nextInt();
                    Student searchedStudent = system.searchStudent(rollNumberToSearch);
                    if (searchedStudent != null) {
                        System.out.println("STUDENT FOUND:\n" + searchedStudent);
                    } else {
                        System.out.println("STUDENT NOT FOUND.");
                    }
                    break;
                case 4:
                    System.out.println("ALL STUDENTS:");
                    system.displayAllStudents();
                    break;
                case 5:
                    System.out.print("ENTER FILENAME TO SAVE STUDENT DATA: ");
                    String saveFilename = scanner.nextLine();
                    system.saveStudentDataToFile(saveFilename);
                    break;
                case 6:
                    System.out.print("ENTER FILENAME TO LOAD STUDENT DATA: ");
                    String loadFilename = scanner.nextLine();
                    system.loadStudentDataFromFile(loadFilename);
                    break;
                case 7:
                    System.out.println("EXITING STUDENT MANAGEMENT SYSTEM. GOODBYE!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("INVALID CHOICE. PLEASE SELECT A VALID OPTION.");
            }
        }
    }
}