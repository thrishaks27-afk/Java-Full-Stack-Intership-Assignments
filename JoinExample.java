package myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JoinExample {

    static final String URL = "jdbc:mysql://localhost:5000/universitydb";
    static final String USER = "root";
    static final String PASSWORD = "Thrisha@123";

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = con.createStatement();

            // ---------------- INNER JOIN TABLES ----------------
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Students(student_id INT PRIMARY KEY, name VARCHAR(50))");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Clubs(club_id INT PRIMARY KEY, club_name VARCHAR(50))");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Student_Club(student_id INT, club_id INT)");

            st.executeUpdate("DELETE FROM Students");
            st.executeUpdate("DELETE FROM Clubs");
            st.executeUpdate("DELETE FROM Student_Club");

            st.executeUpdate("INSERT INTO Students VALUES(1,'Rahul'),(2,'Priya'),(3,'Amit'),(4,'Neha')");
            st.executeUpdate("INSERT INTO Clubs VALUES(101,'Robotics'),(102,'Photography')");
            st.executeUpdate("INSERT INTO Student_Club VALUES(1,101),(2,102),(3,101)");

            System.out.println("INNER JOIN RESULT");
            System.out.println("------------------");

            ResultSet rs1 = st.executeQuery(
                    "SELECT Students.name, Clubs.club_name " +
                    "FROM Students " +
                    "INNER JOIN Student_Club ON Students.student_id = Student_Club.student_id " +
                    "INNER JOIN Clubs ON Student_Club.club_id = Clubs.club_id"
            );

            while(rs1.next()) {
                System.out.println(rs1.getString(1) + " | " + rs1.getString(2));
            }


            // ---------------- LEFT JOIN TABLES ----------------
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Users(user_id INT PRIMARY KEY, name VARCHAR(50))");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Subscriptions(sub_id INT PRIMARY KEY, user_id INT, plan VARCHAR(50))");

            st.executeUpdate("DELETE FROM Users");
            st.executeUpdate("DELETE FROM Subscriptions");

            st.executeUpdate("INSERT INTO Users VALUES(1,'Arjun'),(2,'Sneha'),(3,'Karan'),(4,'Meera')");
            st.executeUpdate("INSERT INTO Subscriptions VALUES(201,1,'Premium'),(202,2,'Basic')");

            System.out.println("\nLEFT JOIN RESULT");
            System.out.println("------------------");

            ResultSet rs2 = st.executeQuery(
                    "SELECT Users.name, Subscriptions.plan " +
                    "FROM Users " +
                    "LEFT JOIN Subscriptions ON Users.user_id = Subscriptions.user_id"
            );

            while(rs2.next()) {
                System.out.println(rs2.getString(1) + " | " + rs2.getString(2));
            }


            // ---------------- RIGHT JOIN TABLES ----------------
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Authors(author_id INT PRIMARY KEY, author_name VARCHAR(50))");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Books(book_id INT PRIMARY KEY, title VARCHAR(100), author_id INT)");

            st.executeUpdate("DELETE FROM Authors");
            st.executeUpdate("DELETE FROM Books");

            st.executeUpdate("INSERT INTO Authors VALUES(1,'R.K. Narayan'),(2,'Chetan Bhagat')");
            st.executeUpdate("INSERT INTO Books VALUES(301,'Malgudi Days',1),(302,'Five Point Someone',2),(303,'Unknown Mystery',NULL)");

            System.out.println("\nRIGHT JOIN RESULT");
            System.out.println("------------------");

            ResultSet rs3 = st.executeQuery(
                    "SELECT Books.title, Authors.author_name " +
                    "FROM Authors " +
                    "RIGHT JOIN Books ON Authors.author_id = Books.author_id"
            );

            while(rs3.next()) {
                System.out.println(rs3.getString(1) + " | " + rs3.getString(2));
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}