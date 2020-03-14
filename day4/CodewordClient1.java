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

/**
 *
 * @author student
 */
public class CodewordClient1 {
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
        int a=0;
        int k[]= new int[4];
        String str1[]= new String[4];
        str1[0]="00000";
        str1[1]="01011";
        str1[2]="10101";
        str1[3]="11110";
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
           //System.out.println(str1[a]);
        }
        OutputStream sout= s1.getOutputStream();
        DataOutputStream dos= new DataOutputStream(sout);
        dos.writeUTF(str1[a]);
        dos.close();
        dis.close();
        is.close();
        sout.close();
        s1.close();
        }
}
