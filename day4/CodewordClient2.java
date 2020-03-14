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
import java.util.Scanner;
/**
 *
 * @author student
 */
public class CodewordClient2 {
    public static void main(String args[])throws IOException{
        int n1=0, n2=0, a=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter n1");
        n1=sc.nextInt();
        System.out.println("Enter n2");
        n2=sc.nextInt();
        System.out.println("Crunning");
        ServerSocket s= new ServerSocket(50000);
        System.out.println("Crunning");
        Socket s1= s.accept();
        System.out.println("Crunning");
        OutputStream os= s1.getOutputStream();
        DataOutputStream dos= new DataOutputStream(os);
        if(n1>=0 && n1<=3 && n2>=0 && n2<=3)
        {
            a=1;
        }
        else
        {
            System.out.println("Invalid input");
        }
        if(a==1)
        {
            if(n1+n2<=3)
            {
                a=1;
            }
            else
            {
                a=0;
            }
        }
        if(a==1)
        {
        String str1[]= new String[4];
        str1[0]="00000";
        str1[1]="01011";
        str1[2]="10101";
        str1[3]="11110";
        String c1,c2;
        c1=str1[n1];
        c2=str1[n2];
        dos.writeUTF(c1);
        dos.writeUTF(c2);
        InputStream is=s1.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        String st =new String(dis.readUTF());
        System.out.println("Received sum="+st);
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
           System.out.println("Sum="+str1[a]);
        }
        dos.close();
        //dis.close();
        os.close();
        //is.close();
        s1.close();
        s.close();
    }
    }    
}
