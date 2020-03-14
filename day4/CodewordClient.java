/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day4;

/**
 *
 * @author student
 */
import java.net.*;
import java.io.*;
public class CodewordClient {
    public static void main(String args[])throws IOException
    {
        System.out.println("Crunning");
        Socket s1=new Socket("localhost", 50000);
        System.out.println("Crunning");
        InputStream is=s1.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        String st =new String(dis.readUTF());
        //dos.writeUTF(st);
        System.out.println(st);
        if(st.equals("00000")||st.equals("01011")||st.equals("10101")||st.equals("11110"))
        {
            System.out.println("Codeword is valid");
        }
        else
        {
           System.out.println("Codeword is invalid"); 
        }
        //dos.close();
        dis.close();
        is.close();
        //sout.close();
        s1.close();
        }
    
}
