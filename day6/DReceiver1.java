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
public class DReceiver1 {
    public static void main(String args[]) throws Exception{
        DatagramSocket ds= new DatagramSocket(3000);
        byte[] buf=new byte[1024];
        DatagramPacket dp= new DatagramPacket(buf,1024);
        ds.receive(dp);
        String str= new String(dp.getData(),0,dp.getData().length);
        System.out.println(str);
        System.out.println(dp.getAddress().toString());
        String str2="";
        char e;
        for(int i=0; i<str.length(); i++)
        {
            char a=str.charAt(i);
            int d=a;
            //System.out.println(d);
            if(d!=32)
            {
            if(d<97)
            {
                d=d+32;
                e=(char)d;
                str2= str2 + e;
            }
            else
            {
                d=d-32;
                e=(char)d;
                str2= str2 + e;
            }
            }
            else
            {
                str2=str2+ " ";    
            }
        }
        System.out.println(str2);
        ds.close();
        DatagramSocket ds1= new DatagramSocket();
        InetAddress ip=InetAddress.getByName("127.0.0.1");
        DatagramPacket dp1= new DatagramPacket(str2.getBytes(),str2.length(),ip,4000);
        ds1.send(dp1);
        ds1.close();
    }
}
