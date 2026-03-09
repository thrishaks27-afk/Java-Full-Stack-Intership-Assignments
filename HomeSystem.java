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
    

// 🔹 Abstraction
abstract class Appliance {
    private String name;
    private boolean status;   // Encapsulation

    public Appliance(String name) {
        this.name = name;
        this.status = false;  // Initially OFF
    }

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }

    // Modified ON method
    public void turnOn() {
        if (status) {
            System.out.println(name + " is already ON");
        } else {
            status = true;
            System.out.println(name + " is now ON");
        }
    }

    // Modified OFF method
    public void turnOff() {
        if (!status) {
            System.out.println(name + " is already OFF");
        } else {
            status = false;
            System.out.println(name + " is now OFF");
        }
    }

    public abstract void showApplianceType();
}

// 🔹 Inheritance
class Fan extends Appliance {
    public Fan() {
        super("Fan");
    }

    public void showApplianceType() {
        System.out.println("Cooling Appliance");
    }
}

class Light extends Appliance {
    public Light() {
        super("Light");
    }

    public void showApplianceType() {
        System.out.println("Lighting Appliance");
    }
}

class AC extends Appliance {
    public AC() {
        super("AC");
    }

    public void showApplianceType() {
        System.out.println("Air Conditioning Appliance");
    }
}

// 🔹 Main Class
public class HomeSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Objects created once → state remembered
        Appliance fan = new Fan();
        Appliance light = new Light();
        Appliance ac = new AC();

        while (true) {

            System.out.println("\nChoose Appliance:");
            System.out.println("1. Fan");
            System.out.println("2. Light");
            System.out.println("3. AC");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Exiting System...");
                break;
            }

            Appliance appliance = null;   // Polymorphism

            switch (choice) {
                case 1:
                    appliance = fan;
                    break;
                case 2:
                    appliance = light;
                    break;
                case 3:
                    appliance = ac;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            appliance.showApplianceType();

            System.out.println("1. Turn ON");
            System.out.println("2. Turn OFF");

            int action = sc.nextInt();

            if (action == 1) {
                appliance.turnOn();
            } else if (action == 2) {
                appliance.turnOff();
            } else {
                System.out.println("Invalid action!");
            }
        }

        sc.close();
    }
}
    

