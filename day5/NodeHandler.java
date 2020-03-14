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
public class NodeHandler {
    public static void main(String args[]) throws IOException
    {
        Node n=new Node();
        System.out.println("Enter choice");
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        if(s.charAt(0)== 's')
        {
            System.out.println("Enter string");
            String s1=sc.next();
            n.send(s1);
        }
        else
        {
            System.out.println("Receiving");
            n.receive();
        }
    }
}
