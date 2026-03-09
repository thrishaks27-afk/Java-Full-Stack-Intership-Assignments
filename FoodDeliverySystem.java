package myproject;


import java.sql.*;

public class FoodDeliverySystem {

    static final String URL = "jdbc:mysql://localhost:5000/";
    static final String USER = "root";
    static final String PASSWORD = "Thrisha@123";

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = con.createStatement();

            // Create Database
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS food_delivery");
            stmt.execute("USE food_delivery");

            // Create Customers Table
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Customers (" +
                    "customer_id INT PRIMARY KEY," +
                    "name VARCHAR(100)," +
                    "city VARCHAR(100)," +
                    "phone VARCHAR(15))");

            // Create Restaurants Table
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Restaurants (" +
                    "restaurant_id INT PRIMARY KEY," +
                    "restaurant_name VARCHAR(100)," +
                    "city VARCHAR(100)," +
                    "rating DOUBLE)");

            // Create Food_Items Table
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Food_Items (" +
                    "food_id INT PRIMARY KEY," +
                    "food_name VARCHAR(100)," +
                    "price DOUBLE," +
                    "restaurant_id INT)");

            // Create Orders Table
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Orders (" +
                    "order_id INT PRIMARY KEY," +
                    "customer_id INT," +
                    "food_id INT," +
                    "quantity INT," +
                    "order_date DATE)");

            System.out.println("Tables created successfully!");

            // Insert Customers
            stmt.executeUpdate("INSERT INTO Customers VALUES (1,'Ananya','Chennai','9876543210')");
            stmt.executeUpdate("INSERT INTO Customers VALUES (2,'Rahul','Bangalore','9876543211')");
            stmt.executeUpdate("INSERT INTO Customers VALUES (3,'Arjun','Hyderabad','9876543212')");

            // Insert Restaurants
            stmt.executeUpdate("INSERT INTO Restaurants VALUES (1,'Pizza Palace','Chennai',4.5)");
            stmt.executeUpdate("INSERT INTO Restaurants VALUES (2,'Burger Hub','Bangalore',4.2)");

            // Insert Food Items
            stmt.executeUpdate("INSERT INTO Food_Items VALUES (1,'Margherita Pizza',250,1)");
            stmt.executeUpdate("INSERT INTO Food_Items VALUES (2,'Veg Burger',120,2)");
            stmt.executeUpdate("INSERT INTO Food_Items VALUES (3,'Cheese Pizza',220,1)");

            // Insert Orders
            stmt.executeUpdate("INSERT INTO Orders VALUES (1,1,1,2,'2026-03-01')");
            stmt.executeUpdate("INSERT INTO Orders VALUES (2,2,2,1,'2026-03-02')");

            System.out.println("Data inserted successfully!");

            // Task 1: SELECT
            System.out.println("\nAll Food Items:");
            ResultSet rs = stmt.executeQuery("SELECT * FROM Food_Items");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getDouble(3) + " " +
                        rs.getInt(4));
            }

            // Task 2: WHERE
            System.out.println("\nFood items price > 200:");
            rs = stmt.executeQuery("SELECT * FROM Food_Items WHERE price > 200");
            while (rs.next()) {
                System.out.println(rs.getString("food_name") + " - " + rs.getDouble("price"));
            }

            // Task 3: AND
            System.out.println("\nFood items price >150 AND restaurant_id=2:");
            rs = stmt.executeQuery("SELECT * FROM Food_Items WHERE price >150 AND restaurant_id=2");
            while (rs.next()) {
                System.out.println(rs.getString("food_name"));
            }

            // Task 3: OR
            System.out.println("\nRestaurants in Chennai OR Bangalore:");
            rs = stmt.executeQuery("SELECT * FROM Restaurants WHERE city='Chennai' OR city='Bangalore'");
            while (rs.next()) {
                System.out.println(rs.getString("restaurant_name") + " - " + rs.getString("city"));
            }

            // Task 4: LIKE
            System.out.println("\nCustomers starting with A:");
            rs = stmt.executeQuery("SELECT * FROM Customers WHERE name LIKE 'A%'");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            System.out.println("\nFood items containing Pizza:");
            rs = stmt.executeQuery("SELECT * FROM Food_Items WHERE food_name LIKE '%Pizza%'");
            while (rs.next()) {
                System.out.println(rs.getString("food_name"));
            }

            // Task 5: BETWEEN
            System.out.println("\nFood price between 100 and 300:");
            rs = stmt.executeQuery("SELECT * FROM Food_Items WHERE price BETWEEN 100 AND 300");
            while (rs.next()) {
                System.out.println(rs.getString("food_name") + " - " + rs.getDouble("price"));
            }

            // Task 6: ORDER BY
            System.out.println("\nFood items sorted by price (high to low):");
            rs = stmt.executeQuery("SELECT * FROM Food_Items ORDER BY price DESC");
            while (rs.next()) {
                System.out.println(rs.getString("food_name") + " - " + rs.getDouble("price"));
            }

            con.close();
            System.out.println("\nProgram executed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}