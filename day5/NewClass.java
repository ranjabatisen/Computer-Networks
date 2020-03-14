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
public class NewClass {
    public static void main(String args[]) throws IOException
    {
        System.out.println("Enter choice");
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String flag1="111";
        int a=s.indexOf(flag1);
        String s1="";
        s1= s.substring(0,a) + "000" + s.substring(a);
        //System.out.println(s1);
        String str[]=s.split(flag1);
        for(int i=0; i<str.length; i++)
        {
            System.out.println(str[i]);
        }
    }
}
