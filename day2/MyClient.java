/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2;

/**
 *
 * @author student
 */
import java.net.*;
import java.io.*;
public class MyClient {
    public static void main(String args[])throws IOException
    {
        System.out.println("Crunning");
        Socket s1=new Socket("192.168.10.28", 50000);
        System.out.println("Crunning");
        OutputStream sout= s1.getOutputStream();
        DataOutputStream dos= new DataOutputStream(sout);
        InputStream is=s1.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        String st =new String(dis.readUTF());
        String a=st.toUpperCase();
        dos.writeUTF(a);
        System.out.println(st);
        dos.close();
        dis.close();
        is.close();
        sout.close();
        s1.close();
        }
    
}
