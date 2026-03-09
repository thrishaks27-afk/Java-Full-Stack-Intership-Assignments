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

public class FestivalProgram {
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> stalls = new ArrayList<>();
        Queue<String> customers = new LinkedList<>();
        Stack<String> visitedStalls = new Stack<>();
        LinkedList<String> history = new LinkedList<>();

        // ---- Add new food stalls ----
        System.out.print("How many stalls to add: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter stall name: ");
            String stall = sc.nextLine();
            stalls.add(stall);
        }

        // ---- Customers join queue ----
        System.out.print("\nHow many customers: ");
        int c = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < c; i++) {
            System.out.print("Enter customer name: ");
            customers.add(sc.nextLine());
        }

        // ---- Serve customers in order ----
        System.out.println("\nServing customers...");
        while (!customers.isEmpty()) {
            String served = customers.poll();
            System.out.println("Served: " + served);
            history.add(served);
        }

        // ---- Track last visited stalls ----
        visitedStalls.push("Snacks Stall");
        visitedStalls.push("Juice Stall");
        visitedStalls.push("Dessert Stall");

        System.out.println("\nLast visited stall: " + visitedStalls.pop());

        // ---- Show daily festival history ----
        System.out.println("\nDaily Festival Customer History:");
        System.out.println(history);

        sc.close();
    }
}
    

