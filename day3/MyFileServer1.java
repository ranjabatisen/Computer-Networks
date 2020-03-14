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
import java.util.*;
public class MyFileServer1 {
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
        ServerSocket servsock=null;
        Socket sock=null;
        //sock= new Socket("127.0.0.1",53267);
        try
        {
            servsock=new ServerSocket(53267);
            while(true)
            {
                System.out.println("Waiting...");
                try
                {
                    sock=servsock.accept();
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
                    
                    //System.out.println(Arrays.toString(mybytearray));/*for(int i=0; i<mybytearray.length; i++)
                 
                    bos.write(mybytearray,0,current);
                    bos.flush();
                    System.out.println("File "+"C:/Users/student/Desktop/csec_148/faculty2.txt"+" downloaded ("+current+" bytes read)");
                    System.out.println("Done");
                    File myFile=new File("C:/Users/student/Desktop/csec_148/faculty2.txt");
                    fis=new FileInputStream(myFile);
                    bis=new BufferedInputStream(fis);
                    bis.read(mybytearray,0,mybytearray.length);
                    os=sock.getOutputStream();
                    System.out.println("Sending "+"C:/Users/student/Desktop/csec_148/faculty2.txt"+"("+mybytearray.length+"bytes)");
                    os.write(mybytearray,0,mybytearray.length);
                    os.flush();
                }
                finally
                {
                    if(bis!=null)
                    {
                        bis.close();
                    }
                    if(os!=null)
                    {
                        os.close();
                    }
                    if(sock!=null)
                    {
                        sock.close();
                    }
                }
            }
        }
        finally
        {
            if(servsock!=null)
            {
                servsock.close();
            }
        }
    }
}
