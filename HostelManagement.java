package mongodb;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class HostelManagement {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String uri = "";
        MongoClient client = MongoClients.create(uri);
        MongoDatabase db = client.getDatabase("hostelDB");

        MongoCollection<Document> students = db.getCollection("students");
        MongoCollection<Document> complaints = db.getCollection("complaints");
        MongoCollection<Document> bookings = db.getCollection("bookings");

        while (true) {
            System.out.println("\n1. Student Login\n2. Admin Login\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    studentMenu(students, complaints, bookings);
                    break;

                case 2:
                    adminMenu(complaints, bookings);
                    break;

                case 3:
                    System.out.println("Exit...");
                    return;
            }
        }
    }

    // ================= STUDENT =================
    static void studentMenu(MongoCollection<Document> students,
                            MongoCollection<Document> complaints,
                            MongoCollection<Document> bookings) {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        students.insertOne(new Document("studentId", id).append("name", name));

        while (true) {
            System.out.println("\n1. Raise Complaint\n2. View Complaints\n3. Book Resource\n4. Cancel Booking\n5. Logout");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Type: ");
                    String type = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();

                    complaints.insertOne(new Document("studentId", id)
                            .append("type", type)
                            .append("description", desc)
                            .append("status", "Pending"));

                    System.out.println("Complaint Added");
                    break;

                case 2:
                    for (Document doc : complaints.find(eq("studentId", id))) {
                        System.out.println(doc.toJson());
                    }
                    break;

                case 3:
                    System.out.print("Resource: ");
                    String res = sc.nextLine();
                    System.out.print("Time Slot: ");
                    String slot = sc.nextLine();

                    // check duplicate
                    if (bookings.find(eq("timeSlot", slot)).first() != null) {
                        System.out.println("Slot already booked!");
                    } else {
                        bookings.insertOne(new Document("resource", res)
                                .append("studentId", id)
                                .append("timeSlot", slot));
                        System.out.println("Booked Successfully");
                    }
                    break;

                case 4:
                    System.out.print("Enter Time Slot to Cancel: ");
                    String cancelSlot = sc.nextLine();

                    bookings.deleteOne(eq("timeSlot", cancelSlot));
                    System.out.println("Booking Cancelled");
                    break;

                case 5:
                    return;
            }
        }
    }

    // ================= ADMIN =================
    static void adminMenu(MongoCollection<Document> complaints,
                          MongoCollection<Document> bookings) {

        while (true) {
            System.out.println("\n1. View Complaints\n2. Update Status\n3. View Bookings\n4. Logout");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    for (Document doc : complaints.find()) {
                        System.out.println(doc.toJson());
                    }
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Status: ");
                    String status = sc.nextLine();

                    complaints.updateOne(eq("studentId", id),
                            set("status", status));

                    System.out.println("Status Updated");
                    break;

                case 3:
                    for (Document doc : bookings.find()) {
                        System.out.println(doc.toJson());
                    }
                    break;

                case 4:
                    return;
            }
        }
    }
}
