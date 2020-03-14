/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day5;
import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author student
 */
public class NewClass1 {
    public static void main(String args[]) throws IOException
    {
        System.out.println("Enter choice");
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String flag1="111";
        String esc="000";
        int i=0, j=0;
        j=s.indexOf(flag1);
        System.out.println(j);
        String s1="";
        s1= s.substring(0,j) + esc + s.substring(j);
        System.out.println(s1);
        String s2=s.substring(j+flag1.length());
        System.out.println(s2);
        i=s2.indexOf(flag1);
        s1= s1 + s2.substring(0,i) + esc + s2.substring(i);
        System.out.println(s1);
        while(i!=j)
        {
           s2=s2.substring(j+flag1.length()); 
           System.out.println(s2);
           j=i;
           i=s2.indexOf(flag1);
           System.out.println(i);
           s1= s1 + s2.substring(0,i) + esc + s2.substring(i);
           System.out.println(s1);
        }
    }
}
