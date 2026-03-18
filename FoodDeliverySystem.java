package mongodb;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.*;
import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;

public class FoodDeliverySystem {

    public static void main(String[] args) {

        String uri = "mongodb+srv://ThrishaKS:Thrisha123@cluster0.dctg0cz.mongodb.net/?appName=Cluster0"; // or your Atlas URI
        MongoClient client = MongoClients.create(uri);

        MongoDatabase db = client.getDatabase("foodDB");
        MongoCollection<Document> orders = db.getCollection("orders");

        // 🔹 1. Insert Data
        orders.insertMany(Arrays.asList(
                new Document("order_id", 101).append("customer_name", "Rahul").append("restaurant", "Pizza Hut").append("food_item", "Pizza").append("quantity", 2).append("price", 500).append("city", "Bangalore").append("status", "Delivered"),
                new Document("order_id", 102).append("customer_name", "Anu").append("restaurant", "KFC").append("food_item", "Burger").append("quantity", 1).append("price", 200).append("city", "Chennai").append("status", "Pending"),
                new Document("order_id", 103).append("customer_name", "Ravi").append("restaurant", "Dominos").append("food_item", "Pizza").append("quantity", 3).append("price", 900).append("city", "Bangalore").append("status", "Delivered"),
                new Document("order_id", 104).append("customer_name", "Priya").append("restaurant", "Subway").append("food_item", "Sandwich").append("quantity", 2).append("price", 300).append("city", "Hyderabad").append("status", "Pending"),
                new Document("order_id", 105).append("customer_name", "Kiran").append("restaurant", "Pizza Hut").append("food_item", "Pasta").append("quantity", 1).append("price", 350).append("city", "Chennai").append("status", "Delivered")
        ));

        System.out.println("Data Inserted\n");

        // 🔹 2. Read Operations

        System.out.println("All Orders:");
        for (Document doc : orders.find()) {
            System.out.println(doc.toJson());
        }

        System.out.println("\nOrders from Bangalore:");
        for (Document doc : orders.find(eq("city", "Bangalore"))) {
            System.out.println(doc.toJson());
        }

        System.out.println("\nDelivered Orders:");
        for (Document doc : orders.find(eq("status", "Delivered"))) {
            System.out.println(doc.toJson());
        }

        // 🔹 3. Aggregations

        // a) Total revenue by city
        System.out.println("\nTotal Revenue by City:");
        orders.aggregate(Arrays.asList(
                group("$city", sum("totalRevenue", "$price"))
        )).forEach(doc -> System.out.println(doc.toJson()));

        // b) Most ordered food item
        System.out.println("\nMost Ordered Food Item:");
        orders.aggregate(Arrays.asList(
                group("$food_item", sum("count", 1)),
                sort(descending("count")),
                limit(1)
        )).forEach(doc -> System.out.println(doc.toJson()));

        // c) Average order value per restaurant
        System.out.println("\nAverage Order per Restaurant:");
        orders.aggregate(Arrays.asList(
                group("$restaurant", avg("avgPrice", "$price"))
        )).forEach(doc -> System.out.println(doc.toJson()));

        // d) Count by status
        System.out.println("\nOrder Count by Status:");
        orders.aggregate(Arrays.asList(
                group("$status", sum("count", 1))
        )).forEach(doc -> System.out.println(doc.toJson()));

        // 🔹 4. Indexing
        orders.createIndex(new Document("customer_name", 1));
        orders.createIndex(new Document("city", 1));
        System.out.println("\nIndexes created");

        // 🔹 5. Advanced Query
        System.out.println("\nOrders with price > 300:");
        for (Document doc : orders.find(gt("price", 300)).sort(descending("price"))) {
            System.out.println(doc.toJson());
        }

        client.close();
    }
}