/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package scannerdemo;
import java.util.Scanner;

public class ScannerDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

System.out.println("Enter college name:");
String colname = s.nextLine();

System.out.println("Enter student name:");
String name = s.next();

System.out.println("Enter rollno:");
int rollno = s.nextInt();

System.out.println("Enter student score:");
float score = s.nextFloat();

System.out.println("Enter semester:");
byte sem = s.nextByte();

System.out.println("Enter gender:");
char gender = s.next().charAt(0);

System.out.println("Rollno = " + rollno);
System.out.println("Sem = " + sem);
System.out.println("Student name = " + name);
System.out.println("College name = " + colname);
System.out.println("Score = " + score);
   }
    
}
