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
public class MyFileClient1 {
    public final static int FILE_SIZE=6022386;
    public static void main(String args[])throws IOException
    {
        int bytesRead;
        int current=0;
        FileOutputStream fos=null;
        BufferedOutputStream bos=null;
        FileInputStream fis= null;
        BufferedInputStream bis=null;
        OutputStream os=null;
        //ServerSocket servsock=null;
        Socket sock=null;
        /*servsock=new ServerSocket(53267);
        sock=servsock.accept();*/
        try
        {
            sock= new Socket("127.0.0.1",53267);
            String a;
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter path");
            a=sc.next();
            File myFile=new File(a);
            byte[] mybytearray= new byte[(int)myFile.length()];
            fis=new FileInputStream(myFile);
            bis=new BufferedInputStream(fis);
            bis.read(mybytearray,0,mybytearray.length);
            os=sock.getOutputStream();
            System.out.println("Sending "+a+"("+mybytearray.length+"bytes)");
            os.write(mybytearray,0,mybytearray.length);
            os.flush();
            System.out.println("Done");
            System.out.println("Connecting...");
            //byte[] mybytearray= new byte[FILE_SIZE];
            InputStream is=sock.getInputStream();
            fos= new FileOutputStream("C:/Users/student/Desktop/csec_148/faculty3.txt");
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
            System.out.println("File "+"C:/Users/student/Desktop/csec_148/faculty3.txt"+" downloaded ("+current+" bytes read)");
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
