/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scannerdemo;

/**
 *
 * @author admin
 */
import java.util.Scanner;

public class CompareTrilets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[3];
        int[] b = new int[3];

        for (int i = 0; i < 3; i++)
            a[i] = sc.nextInt();

        for (int i = 0; i < 3; i++)
            b[i] = sc.nextInt();

        int alice = 0, bob = 0;

        for (int i = 0; i < 3; i++) {
            if (a[i] > b[i]) alice++;
            else if (a[i] < b[i]) bob++;
        }

        System.out.println(alice + " " + bob);
    }
}
    

