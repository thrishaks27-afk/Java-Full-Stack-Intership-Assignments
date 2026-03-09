/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scannerdemo;

/**
 *
 * @author admin
 */
public class PaliDemo {

static  public void main(String args[])
{
StringBuilder s1=new StringBuilder("malayalam");

//StringBuilder s3=s1.toLowerCase();
StringBuilder s4=s1.reverse();
if(s1.equals(s4))
System.out.println("The string is palindrome");
else
System.out.println("The string is not a palindrome");
}}


