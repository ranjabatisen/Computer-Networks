/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author student
 */
public class CodewordServer1 {
     public static void main(String args[])throws IOException{
        System.out.println("Srunning");
        ServerSocket s= new ServerSocket(50000);
        System.out.println("Srunning");
        Socket s1= s.accept();
        System.out.println("Srunning");
        OutputStream os= s1.getOutputStream();
        DataOutputStream dos= new DataOutputStream(os);
        dos.writeUTF("11011");
        InputStream is=s1.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        String st =new String(dis.readUTF());
        System.out.println("Correct codeword="+st);
        dos.close();
        dis.close();
        os.close();
        is.close();
        s1.close();
        s.close();
    }
    
}
