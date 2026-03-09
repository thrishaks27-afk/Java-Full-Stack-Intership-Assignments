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
public class CamelCase {
    
    public static boolean isCamelCase(String str) {

        if (str.length() == 0 || !Character.isUpperCase(str.charAt(0)))
            return false;

        if (str.contains(" "))
            return false;

        for (int i = 1; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i)))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isCamelCase(input))
            System.out.println("The string is CamelCase.");
        else
            System.out.println("The string is NOT CamelCase.");

        sc.close();
    }
}
    

