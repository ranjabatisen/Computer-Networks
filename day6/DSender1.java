/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day6;

/**
 *
 * @author student
 */
import java.net.*;
import java.util.Scanner;
public class DSender1 {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds= new DatagramSocket();
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(str);
        InetAddress ip=InetAddress.getByName("127.0.0.1");
        DatagramPacket dp= new DatagramPacket(str.getBytes(),str.length(),ip,3000);
        ds.send(dp);
        ds.close();
        DatagramSocket ds1= new DatagramSocket(4000);
        byte[] buf=new byte[1024];
        DatagramPacket dp1= new DatagramPacket(buf,1024);
        ds1.receive(dp1);
        String str1= new String(dp1.getData(),0,dp1.getData().length);
        System.out.println(str1);
        System.out.println(dp1.getAddress().toString());
        ds1.close();
    }    
}
