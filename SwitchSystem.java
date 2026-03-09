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

    

public class SwitchSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Switch 1  ");
        int s1 = sc.nextInt();

        System.out.print("Enter Switch 2  ");
        int s2 = sc.nextInt();

        // XOR condition
        if (s1==1 &&  s2==0) {
            System.out.println("Light is Glowing ");
            System.out.println("Fan is Working ");
        } else if(s1==0 && s2==1) {
            System.out.println("Light is  Working ");
            System.out.println("Motor is Working ");
        }
        else{
            System.out.println("None");
        }

        sc.close();
    }
}
    

