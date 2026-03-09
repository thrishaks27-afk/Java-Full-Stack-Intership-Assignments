package myproject;


import java.sql.*;

public class SubqueryExample {

    static final String URL = "jdbc:mysql://localhost:5000/companydb";
    static final String USER = "root";
    static final String PASSWORD = "Thrisha@123";

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = con.createStatement();

            // Requirement 1
            System.out.println("Employees with salary greater than average:");
            ResultSet rs1 = st.executeQuery(
                "SELECT name, salary FROM Employees WHERE salary > (SELECT AVG(salary) FROM Employees)"
            );

            while(rs1.next()) {
                System.out.println(rs1.getString("name") + " | " + rs1.getInt("salary"));
            }

            // Requirement 2
            System.out.println("\nEmployees in IT or Finance:");
            ResultSet rs2 = st.executeQuery(
                "SELECT name FROM Employees WHERE dept_id IN (SELECT dept_id FROM Departments WHERE dept_name IN ('IT','Finance'))"
            );

            while(rs2.next()) {
                System.out.println(rs2.getString("name"));
            }

            // Requirement 3
            System.out.println("\nEmployees earning more than department average:");
            ResultSet rs3 = st.executeQuery(
                "SELECT name, salary, dept_id FROM Employees e WHERE salary > (SELECT AVG(salary) FROM Employees WHERE dept_id = e.dept_id)"
            );

            while(rs3.next()) {
                System.out.println(rs3.getString("name") + " | " + rs3.getInt("salary") + " | " + rs3.getInt("dept_id"));
            }

            // Requirement 4
            System.out.println("\nEmployees working on IT department projects:");
            ResultSet rs4 = st.executeQuery(
                "SELECT name FROM Employees WHERE emp_id IN (SELECT emp_id FROM Projects WHERE emp_id IN (SELECT emp_id FROM Employees WHERE dept_id = 1))"
            );

            while(rs4.next()) {
                System.out.println(rs4.getString("name"));
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}