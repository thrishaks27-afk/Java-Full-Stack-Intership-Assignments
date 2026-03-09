/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scannerdemo;

/**
 *
 * @author admin
 */
class OddThread extends Thread {
    public void run(){
        for (int i=1;i<=10;i++)
        {
            if(i%2!=0){
                System.out.println("Odd Thread:"+i);
                
            }
        }
    }
}
class EvenThread extends Thread {
    public void run(){
        for (int i=1;i<=10;i++)
        {
            if(i%2==0){
                System.out.println("Even Thread:"+i);
            }
        }
    }
}
public class OddEvenThread {
    public static void main (String[]args){
        OddThread t1 = new OddThread();
        EvenThread t2 = new EvenThread();
        t1.start();
        t2.start();
    }
}

