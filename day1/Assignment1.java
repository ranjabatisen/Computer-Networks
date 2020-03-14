/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
/**
 *
 * @author student
 */
public class Assignment1 {
    public static void main(String args[])throws IOException
    {
        DataInputStream d= new DataInputStream(new FileInputStream("C:/Users/student/Desktop/csec_148/abc.txt"));
        DataOutputStream out= new DataOutputStream(new FileOutputStream("C:/Users/student/Desktop/csec_148/abc1.txt"));
        String count;
        Scanner sc= new Scanner(System.in);
        int x=sc.nextInt();
        while((count=d.readLine())!=null){
            System.out.println(count);
            out.writeBytes(count+" ,");
        }
        d.close();
        out.close();
        System.out.println("Done");
    }
    
}
