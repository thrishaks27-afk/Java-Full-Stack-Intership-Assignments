/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scannerdemo;

/**
 *
 * @author admin
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingTotal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int count = sc.nextInt();

        ArrayList<Double> price = new ArrayList<>();
        double sum = 0;

        // Input prices
        for (int i = 0; i < count; i++) {
            System.out.print("Enter price of item " + (i + 1) + ": ");
            double value = sc.nextDouble();
            price.add(value);
            sum += value;
        }

        // Print total
        System.out.println("Total amount: " + sum);

        // Condition check
        if (sum > 2000) {
            System.out.println("Save Money");
        } else {
            System.out.println("Good!");
        }
    }
}

    

    