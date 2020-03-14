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
import java.io.*;
import java.net.*;
import java.util.*;

public class DReceiver2 {
    public static void main(String args[]) throws Exception{
        DatagramSocket ds= new DatagramSocket(50000);
        byte[] buf=new byte[1024];
        DatagramPacket dp= new DatagramPacket(buf,1024);
        //while(true)
        //{
        File f1=new File("C:/Users/student/Desktop/csec_148/log.txt");
        FileWriter fw=new FileWriter(f1.getAbsoluteFile(),true);
        PrintWriter pw=new PrintWriter(fw,true);
        ds.receive(dp);
        String str= new String(dp.getData(),0,dp.getData().length);
        System.out.println(str);
        System.out.println(dp.getAddress().toString());
        pw.println(str);
        pw.println("From port: "+dp.getPort());
        pw.println(dp.getAddress().toString());
        fw.close();
        pw.close();
        //}
        ds.close();
    }
}
