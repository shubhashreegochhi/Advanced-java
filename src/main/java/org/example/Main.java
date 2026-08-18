package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    static final String USER = "root";
    static final String PASSWORD = "shubha@2610";

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Employee");
            System.out.println("2. Get Employee By ID");
            System.out.println("3. View All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    registerEmployee();
                    break;

                case 2:
                    getEmployeeById();
                    break;

                case 3:
                    viewAllEmployees();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }


    public static void registerEmployee() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "INSERT INTO employee(name, email, salary) VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, salary);

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Employee Registered Successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. Get Employee By ID
    public static void getEmployeeById() {

        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine();

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "SELECT * FROM employee WHERE emp_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, empId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Emp ID : " + rs.getInt("emp_id"));
                System.out.println("Name   : " + rs.getString("name"));
                System.out.println("Email  : " + rs.getString("email"));
                System.out.println("Salary : " + rs.getDouble("salary"));
            } else {
                System.out.println("Employee Not Found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewAllEmployees() {

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "SELECT * FROM employee";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- List of All Employees ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("emp_id") + " | "
                        + "Name: " + rs.getString("name") + " | "
                        + "Email: " + rs.getString("email") + " | "
                        + "Salary: " + rs.getDouble("salary"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void updateEmployee() {

        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine(); // Clear buffer

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Email: ");
        String email = sc.nextLine();

        System.out.print("Enter New Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine(); // Clear buffer

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "UPDATE employee SET name=?, email=?, salary=? WHERE emp_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, salary);
            ps.setInt(4, empId);

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Employee Updated Successfully");
            else
                System.out.println("Employee Not Found");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void deleteEmployee() {

        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine();

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "DELETE FROM employee WHERE emp_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, empId);

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Employee Deleted Successfully");
            else
                System.out.println("Employee Not Found");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}