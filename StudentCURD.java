package mongodb;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class StudentCURD {

    public static void main(String[] args) {

        // 🔹 Replace with your Atlas connection string
        String uri = "";

        MongoClient client = MongoClients.create(uri);

        MongoDatabase db = client.getDatabase("studentDB");
        MongoCollection<Document> col = db.getCollection("students");

        System.out.println("Connected to MongoDB");

        // 🔹 INSERT
        Document student = new Document("name", "Rahul")
                .append("age", 22)
                .append("course", "Python Fullstack");

        col.insertOne(student);
        System.out.println("Student inserted");

        // 🔹 READ
        System.out.println("\nStudents List:");
        for (Document doc : col.find()) {
            System.out.println(doc.toJson());
        }

        // 🔹 UPDATE
        col.updateOne(eq("name", "Rahul"),
                set("course", "Java Fullstack"));
        System.out.println("\nStudent updated");

        // 🔹 DELETE
        col.deleteOne(eq("name", "Rahul"));
        System.out.println("\nStudent deleted");

        client.close();
    }
}
