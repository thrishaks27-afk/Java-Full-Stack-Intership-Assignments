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
public class BWMatrix {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter rows:");
        int rows = sc.nextInt();
        
        System.out.println("Enter cols:");
        int cols = sc.nextInt();
        int [][] matrix=new int[rows][cols];
             
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++){
                if((i+j)%2==0)
                {
                    System.out.print(" B ");
                    }else{
            System.out.print(" W ");
        }
        }
        System.out.println();
    }
    }
}
    

