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
public class MyServer {
    public static void main(String args[])throws IOException{
        System.out.println("Srunning");
        ServerSocket s= new ServerSocket(50000);
        System.out.println("Srunning");
        Socket s1= s.accept();
            System.out.println("Srunning");
            OutputStream os= s1.getOutputStream();
            DataOutputStream dos= new DataOutputStream(os);
            dos.writeUTF("Hi!! Ranjabati");
            InputStream is=s1.getInputStream();
        DataInputStream dis=new DataInputStream(is);
            String st =new String(dis.readUTF());
        System.out.println(st);
            dos.close();
            dis.close();
            os.close();
            is.close();
            s1.close();
        s.close();
    }
}
