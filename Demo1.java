package myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo1 {

    private static final String URL = "jdbc:mysql://localhost:5000/mydb1";
    private static final String USER = "root";
    private static final String PASSWORD = "Thrisha@123";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("✅ Connected to Database\n");

            // 1️⃣ Insert 5 records
            String insertSQL = "INSERT INTO Student (RollNo, name, city) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {

                Object[][] students = {
                        {101, "Anu", "Chennai"},
                        {102, "Ravi", "Bangalore"},
                        {103, "Kiran", "Hyderabad"},
                        {104, "Meena", "Delhi"},
                        {105, "Arjun", "Mumbai"}
                };

                for (Object[] s : students) {
                    ps.setInt(1, (int) s[0]);
                    ps.setString(2, (String) s[1]);
                    ps.setString(3, (String) s[2]);
                    ps.executeUpdate();
                }

                System.out.println("✅ 5 Records Inserted Successfully\n");
            }

            System.out.println("📌 Data After Insert:");
            displayData(conn);

            // 2️⃣ Delete one record
            String deleteSQL = "DELETE FROM Student WHERE RollNo = ?";
            try (PreparedStatement ps = conn.prepareStatement(deleteSQL)) {
                ps.setInt(1, 103);
                ps.executeUpdate();
                System.out.println("\n✅ Record with RollNo 103 Deleted\n");
            }

            System.out.println("📌 Data After Delete:");
            displayData(conn);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // Method to display records
    public static void displayData(Connection conn) throws Exception {

        String selectSQL = "SELECT * FROM Student";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            while (rs.next()) {
                int rollNo = rs.getInt("RollNo");
                String name = rs.getString("name");
                String city = rs.getString("city");

                System.out.println("RollNo: " + rollNo +
                        ", Name: " + name +
                        ", City: " + city);
            }
        }
    }
}