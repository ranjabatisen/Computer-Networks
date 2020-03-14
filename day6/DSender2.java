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

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class DSender2 {
    public static void main(String args[]) throws Exception{
        DatagramSocket ds= new DatagramSocket();
        Date d= new Date();
        String str1=d.toString();
        String s1= "USER:" + System.getProperty("user.name") + "OS_NAME:" + System.getProperty("os.name")+ "OS_VERSION:" + System.getProperty("os.version")+ "DATE:"+ str1;
        System.out.println(s1);
        //InetAddress ip=InetAddress.getByName("192.168.10.38");
        InetAddress ip=InetAddress.getByName("127.0.0.1");
        DatagramPacket dp= new DatagramPacket(s1.getBytes(),s1.length(),ip,50000);
        ds.send(dp);
        ds.close();
    }
}
