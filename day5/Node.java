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
public class Node {
    String flag="01111110";
    String flag1="0110";
    String esc="0101";
    public void send(String s) throws IOException
    {
        //String b=bit_stuffing(s);
        String b=byte_stuffing(s);
        //String a=create_frame(b);
        String a=create_frame1(b);
        //System.out.println(a);
        send_frame(a);
    }
    public String create_frame(String s) throws IOException
    {
        String a=s;
        a=flag+a+flag;
        return a;
    }
    public String create_frame1(String s) throws IOException
    {
        String a=s;
        a=flag1+a+flag1;
        return a;
    }
    public String bit_stuffing(String s)
    {
        int count=0;
        String s1="";
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='1')
            {
                count++;
            }
            else
            {
                count=0;
            }
            s1=s1+ s.charAt(i);
            if(count==5)
            {
                //s=s.substring(0,i)+"0"+s.substring(i+1);
                s1= s1 + "0";
            }
        }
        //System.out.println(s1);
        return s1;
    }
    public String byte_stuffing(String s)
    {
        String str[]=s.split(flag1);
        String s1="";
        for(int i=0; i<str.length; i++)
        {
            s1= s1 + str[i];
        }
        String str2[]=s1.split(esc);
        for(int i=0; i<str.length; i++)
        {
            s1= s1 + str[i] + esc + flag1;
        }
        String str1[]=s.split(esc);
        for(int i=0; i<str1.length; i++)
        {
            s1= s1 + str1[i] + esc + esc;
        }
        return s1;
    }
    public void send_frame(String str) throws IOException
    {
        ServerSocket s= new ServerSocket(50000);
        System.out.println("Srunning");
        Socket s1= s.accept();
        System.out.println("Srunning");
        OutputStream os= s1.getOutputStream();
        DataOutputStream dos= new DataOutputStream(os);
        dos.writeUTF(str);
        System.out.println(str);
        dos.close();
        os.close();
        s1.close();
        s.close();
    }
    public void receive() throws IOException
    {
        System.out.println("Crunning");
        Socket s1=new Socket("localhost", 50000);
        System.out.println("Crunning");
        InputStream is=s1.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        String st =new String(dis.readUTF());
        //String a=extract_data(st);
        //System.out.println(a);
        dis.close();
        is.close();
        s1.close();
    }
    public String extract_data(String s)
    {
       int i=0, j=0;
       int p= s.length()- flag.length();
       String s1="";
       while(j!=flag.length())
       {
       if(s.charAt(i)==flag.charAt(j))
       {
           i++;
           j++;
       }
       else
       {
           break;
       }
       }
       for(int k=i; k<p; k++)
       {
           s1=s1+s.charAt(i);
       }
       String s2="";
       int count=0;
        for(i=0; i<s1.length(); i++)
        {
            if(s1.charAt(i)=='1')
            {
                count++;
            }
            else
            {
                count=0;
            }
            s2=s2+ s1.charAt(i);
            if(count==5)
            {
                //s=s.substring(0,i)+"0"+s.substring(i+1);
                i++;
            }
        }
        //System.out.println(s1);
        //System.out.println(s2);
        return s2;
    }
}
