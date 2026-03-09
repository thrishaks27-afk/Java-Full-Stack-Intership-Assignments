/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scannerdemo;

/**
 *
 * @author admin
 */
import java.util.regex.*;

public class PasswordCheck {
       public static boolean checkPassword(String password) 
{
        String rules = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&-+=()])(?=\\S$).{8,20}$";
        Pattern pattern = Pattern.compile(rules);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(checkPassword("weak")); // true
        System.out.println(checkPassword("Srinivas19@yuu")); // false
    }
    
}
