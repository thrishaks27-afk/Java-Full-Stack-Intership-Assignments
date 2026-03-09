/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scannerdemo;

/**
 *
 * @author admin
 */
import java.util.*;

public class FoodFestivalSystem {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> stalls = new ArrayList<>();
        Vector<String> dishes = new Vector<>();
        Queue<String> customers = new LinkedList<>();
        Stack<String> backTrack = new Stack<>();
        LinkedList<String> history = new LinkedList<>();

        int choice;

        do {
            System.out.println("\n--- Magical Food Festival ---");
            System.out.println("1. Add Food Stall");
            System.out.println("2. Add Dish (Chef Update)");
            System.out.println("3. Customer Join Queue");
            System.out.println("4. Serve Customer");
            System.out.println("5. Customer Go Back (Forgot Item)");
            System.out.println("6. Show Last Visited Stalls");
            System.out.println("7. Show Daily History");
            System.out.println("8. Show All Stalls");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter stall name: ");
                    String stall = sc.nextLine();
                    stalls.add(stall);
                    backTrack.push(stall);
                    break;

                case 2:
                    System.out.print("Enter dish name: ");
                    dishes.add(sc.nextLine());
                    System.out.println("Dish updated.");
                    break;

                case 3:
                    System.out.print("Enter customer name: ");
                    customers.add(sc.nextLine());
                    break;

                case 4:
                    if (!customers.isEmpty()) {
                        String served = customers.poll();
                        history.add(served);
                        System.out.println("Served: " + served);
                    } else {
                        System.out.println("No customers in queue.");
                    }
                    break;

                case 5:
                    if (!backTrack.isEmpty()) {
                        System.out.println("Go back to stall: " + backTrack.pop());
                    } else {
                        System.out.println("No previous stall.");
                    }
                    break;

                case 6:
                    System.out.println("Last visited stalls: " + backTrack);
                    break;

                case 7:
                    System.out.println("Daily customer history: " + history);
                    break;

                case 8:
                    System.out.println("Food stalls: " + stalls);
                    break;

                case 9:
                    System.out.println("Festival system closed.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        sc.close();
    }
}
    

