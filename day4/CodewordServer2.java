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
public class CodewordServer2 {
    public static void main(String args[])throws IOException{
        System.out.println("Srunning");
        ServerSocket s= new ServerSocket(50001);
        System.out.println("Srunning");
        Socket s1= s.accept();
        System.out.println("Srunning");
        InputStream is=s1.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        String st =new String(dis.readUTF());
        String st1 =new String(dis.readUTF());
        //dos.writeUTF(st);
        System.out.println(st);
        System.out.println(st1);
        String str1[]= new String[4];
        int a=0,a1=0;
        str1[0]="00000";
        str1[1]="01011";
        str1[2]="10101";
        str1[3]="11110";
        int k[]= new int[4];
        for(int i=0; i<4; i++)
        {
            k[i]=0;
        }
        if(st.equals("00000")||st.equals("01011")||st.equals("10101")||st.equals("11110"))
        {
            System.out.println("Codeword is valid");
        }
        else
        {
           System.out.println("Codeword is invalid"); 
           for(int i=0; i<5; i++)
           {
               if(st.charAt(i)!=str1[0].charAt(i))
                {
                    k[0]++;
                }
                if(st.charAt(i)!=str1[1].charAt(i))
                {
                    k[1]++;
                }
                if(st.charAt(i)!=str1[2].charAt(i))
                {
                    k[2]++;
                }
                if(st.charAt(i)!=str1[3].charAt(i))
                {
                    k[3]++;
                }
           }
           int min=100;
           for(int i=0; i<4; i++)
           {
               if(k[i]<min)
               {
                   min=k[i];
                   a=i;
               }
           }
           System.out.println(str1[a]);
        }
        String c1=str1[a];
        for(int i=0; i<4; i++)
        {
            k[i]=0;
        }
        if(st1.equals("00000")||st1.equals("01011")||st1.equals("10101")||st1.equals("11110"))
        {
            System.out.println("Codeword is valid");
        }
        else
        {
           System.out.println("Codeword is invalid"); 
           for(int i=0; i<5; i++)
           {
               if(st1.charAt(i)!=str1[0].charAt(i))
                {
                    k[0]++;
                }
                if(st1.charAt(i)!=str1[1].charAt(i))
                {
                    k[1]++;
                }
                if(st1.charAt(i)!=str1[2].charAt(i))
                {
                    k[2]++;
                }
                if(st1.charAt(i)!=str1[3].charAt(i))
                {
                    k[3]++;
                }
           }
           int min=100;
           for(int i=0; i<4; i++)
           {
               if(k[i]<min)
               {
                   min=k[i];
                   a1=i;
               }
           }
           System.out.println(str1[a1]);
        }
        String c2=str1[a1];
        int sum=a+a1;
        System.out.println("Sum="+sum);
        String c=str1[sum];
        OutputStream os= s1.getOutputStream();
        DataOutputStream dos= new DataOutputStream(os);
        dos.writeUTF(c);
        dis.close();
        dos.close();
        is.close();
        os.close();
        s1.close();
        s.close();
    }
}
