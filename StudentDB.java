package myproject;
import java.sql.*;

public class StudentDB {
	


    static final String URL = "jdbc:mysql://localhost:5000/college_db";
    static final String USER = "root";
    static final String PASSWORD = "Thrisha@123"; // change this

    public static void main(String[] args) {

        try {
            // 1. Load Driver (optional in new versions but safe)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected Successfully!");

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Execute Query
            String sql = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(sql);

            // 5. Display Data
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("age") + " " +
                    rs.getString("department")
                );
            }

            // 6. Close Connection
            con.close();
            System.out.println("Connection Closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


