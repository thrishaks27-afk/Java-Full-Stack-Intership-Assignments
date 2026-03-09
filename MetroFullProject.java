package myproject;
import java.sql.*;
public class MetroFullProject {

    static final String URL = "jdbc:mysql://localhost:5000/"; // only server
    static final String USER = "root";
    static final String PASSWORD = "Thrisha@123"; // change this

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 1: Connect to MySQL Server (not database)
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = con.createStatement();

            // Step 2: Create Database
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS metro_db");
            System.out.println("Database created!");

            // Step 3: Use Database
            stmt.execute("USE metro_db");

            // Step 4: Create Stations Table
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Stations (" +
                    "station_id INT PRIMARY KEY," +
                    "station_name VARCHAR(100)," +
                    "location VARCHAR(100)," +
                    "platforms INT," +
                    "opening_year INT)");

            // Step 5: Create Trains Table
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Trains (" +
                    "train_id INT PRIMARY KEY," +
                    "train_name VARCHAR(100)," +
                    "capacity INT," +
                    "station_id INT," +
                    "FOREIGN KEY (station_id) REFERENCES Stations(station_id))");

            System.out.println("Tables created!");

            // Step 6: Insert Stations
            stmt.executeUpdate("INSERT INTO Stations VALUES (1,'Central','City Center',6,2010)");
            stmt.executeUpdate("INSERT INTO Stations VALUES (2,'North','North Zone',4,2012)");
            stmt.executeUpdate("INSERT INTO Stations VALUES (3,'South','South Zone',5,2015)");

            // Step 7: Insert Trains
            stmt.executeUpdate("INSERT INTO Trains VALUES (101,'Blue Line',800,1)");
            stmt.executeUpdate("INSERT INTO Trains VALUES (102,'Red Line',750,2)");

            // Step 8: Display Data
            System.out.println("\nStations:");
            ResultSet rs = stmt.executeQuery("SELECT * FROM Stations");
            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getInt(4) + " " +
                        rs.getInt(5)
                );
            }

            System.out.println("\nTrains:");
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM Trains");
            while (rs2.next()) {
                System.out.println(
                        rs2.getInt(1) + " " +
                        rs2.getString(2) + " " +
                        rs2.getInt(3) + " " +
                        rs2.getInt(4)
                );
            }

            con.close();
            System.out.println("\nEverything executed successfully in Eclipse!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
