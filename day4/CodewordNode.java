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
import java.net.Socket;
import java.util.Random;
/**
 *
 * @author student
 */
public class CodewordNode {
    public static void main(String args[])throws IOException
    {
        int d=0;
        System.out.println("Srunning");
        Socket s1=new Socket("localhost", 50000);
        Socket s2=new Socket("localhost", 50001);
        System.out.println("Srunning");
        InputStream is=s1.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        InputStream is1=s2.getInputStream();
        DataInputStream dis1=new DataInputStream(is1);
        OutputStream os= s2.getOutputStream();
        DataOutputStream dos= new DataOutputStream(os);
        OutputStream os1= s1.getOutputStream();
        DataOutputStream dos1= new DataOutputStream(os1);
        if(d==0)
        {
        String st =new String(dis.readUTF());
        String st1 =new String(dis.readUTF());
        //dos.writeUTF(st);
        System.out.println(st);
        System.out.println(st1);
        if(st.equals("00000")||st.equals("01011")||st.equals("10101")||st.equals("11110"))
        {
            System.out.println("Codeword is valid");
        }
        else
        {
           System.out.println("Codeword is invalid"); 
        }
        if(st1.equals("00000")||st1.equals("01011")||st1.equals("10101")||st1.equals("11110"))
        {
            System.out.println("Codeword is valid");
        }
        else
        {
           System.out.println("Codeword is invalid"); 
        }
        Random rand= new Random(4);
        int n= rand.nextInt(4);
        StringBuilder seq,seq1;
        if(st.charAt(n)=='0')
        {
            seq=new StringBuilder(st);
            seq.setCharAt(n,'1');
        }
        else
        {
            seq=new StringBuilder(st);
            seq.setCharAt(n,'0');
        }
        if(st1.charAt(n)=='0')
        {
            seq1=new StringBuilder(st1);
            seq1.setCharAt(n,'1');
        }
        else
        {
            seq1=new StringBuilder(st1);
            seq1.setCharAt(n,'0');
        }
        //System.out.println(n);
        String c1,c2;
        c1=seq.toString();
        c2=seq1.toString();
        dos.writeUTF(c1);
        dos.writeUTF(c2);
        d++;
        }
        if(d==1)
        {
        String sum =new String(dis1.readUTF());
        System.out.println("Sum="+sum);
        Random rand= new Random(4);
        int n= rand.nextInt(4);
        StringBuilder seq2;
        if(sum.charAt(n)=='0')
        {
            seq2=new StringBuilder(sum);
            seq2.setCharAt(n,'1');
        }
        else
        {
            seq2=new StringBuilder(sum);
            seq2.setCharAt(n,'0');
        }
        String c;
        c=seq2.toString();
        dos1.writeUTF(c);
        }
        dos.close();
        dos1.close();
        dis.close();
        dis1.close();
        is.close();
        is1.close();
        os.close();
        os1.close();
        s1.close();
    }
}
