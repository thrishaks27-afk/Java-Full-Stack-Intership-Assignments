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

// -------- Custom Exceptions --------
class NegativeValueException extends Exception {
    public NegativeValueException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class NetworkIssueException extends Exception {
    public NetworkIssueException(String msg) {
        super(msg);
    }
}

// -------- Bank Class --------
class Bank {

    private double balance = 4000;

    // Deposit Method
    public void deposit(double amt) throws NegativeValueException, NetworkIssueException {
        if (amt < 0)
            throw new NegativeValueException("Negative amount not allowed");

        // simulate network issue
        if (Math.random() < 0.2)
            throw new NetworkIssueException("Network problem during deposit");

        balance += amt;
        System.out.println("Deposit done. Balance = " + balance);
    }

    // Withdraw Method
    public void withdraw(double amt)
            throws NegativeValueException, InsufficientBalanceException, NetworkIssueException {

        if (amt < 0)
            throw new NegativeValueException("Negative amount not allowed");

        if (amt > balance)
            throw new InsufficientBalanceException("Insufficient balance");

        if (Math.random() < 0.2)
            throw new NetworkIssueException("Network problem during withdraw");

        balance -= amt;
        System.out.println("Withdraw done. Balance = " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

// -------- Main Management Class --------
public class BankingManagementMethod {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        try {
            System.out.println("Current Balance: " + bank.getBalance());

            System.out.print("Enter deposit amount: ");
            double d = sc.nextDouble();
            bank.deposit(d);   // method call

            System.out.print("Enter withdraw amount: ");
            double w = sc.nextDouble();
            bank.withdraw(w);  // method call

        } catch (NegativeValueException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (NetworkIssueException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Final management: Transaction finished.");
        }

        sc.close();
    }
}
    

