/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3;

/**
 *
 * @author student
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class MyFileClient {
    public final static int FILE_SIZE=6022386;
    public static void main(String args[])throws IOException
    {
        int bytesRead;
        int current=0;
        FileOutputStream fos=null;
        BufferedOutputStream bos=null;
        //ServerSocket servsock=null;
        Socket sock=null;
        /*servsock=new ServerSocket(53267);
        sock=servsock.accept();*/
        try
        {
            sock= new Socket("127.0.0.1",53267);
            OutputStream sout= sock.getOutputStream();
            DataOutputStream dos= new DataOutputStream(sout);
            String a;
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter path");
            a=sc.next();
            dos.writeUTF(a);
            System.out.println("Connecting...");
            byte[] mybytearray= new byte[FILE_SIZE];
            InputStream is=sock.getInputStream();
            fos= new FileOutputStream("C:/Users/student/Desktop/csec_148/faculty2.txt");
            bos= new BufferedOutputStream(fos);
            bytesRead= is.read(mybytearray,0,mybytearray.length);
            current=bytesRead;
            do
            {
                bytesRead= is.read(mybytearray, current, (mybytearray.length-current));
                if(bytesRead >=0)
                {
                    current += bytesRead;
                }
            }while(bytesRead > -1);
            bos.write(mybytearray,0,current);
            bos.flush();
            System.out.println("File "+"C:/Users/student/Desktop/csec_148/faculty2.txt"+" downloaded ("+current+" bytes read)");
            dos.close();
            sout.close();
        }
        finally
        {
            if(fos!=null)
            {
                fos.close();
            }
            if(bos!=null)
            {
                bos.close();
            }
            if(sock!=null)
            {
                sock.close();
            }
        }
    }
}
