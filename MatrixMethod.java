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
public class MatrixMethod {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows:");
        int r = sc.nextInt();
        System.out.print("Enter colums:");
        int c =sc.nextInt();
        int[][]mat=new int[r][c];
        System.out.println("Enter matrix elemnts:");
        //input
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++)
            {
                mat[i][j]=sc.nextInt();
            }
        }
        //increment 0th value
        mat[0][0]++;
        System.out.println("Matrix after incrementing 0th value:");
        //output
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
        System.out.println();
    }
    }
    

