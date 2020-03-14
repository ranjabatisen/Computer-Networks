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
public class MyFileServer {
    public static void main(String args[])throws IOException
    {
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
                    InputStream is=sock.getInputStream();
                    DataInputStream dis=new DataInputStream(is);
                    String st =new String(dis.readUTF());
                    System.out.println(st);
                    File myFile=new File(st);
                    byte[] mybytearray= new byte[(int)myFile.length()];
                    fis=new FileInputStream(myFile);
                    bis=new BufferedInputStream(fis);
                    bis.read(mybytearray,0,mybytearray.length);
                    os=sock.getOutputStream();
                    System.out.println("Sending "+st+"("+mybytearray.length+"bytes)");
                    os.write(mybytearray,0,mybytearray.length);
                    os.flush();
                    System.out.println("Done");
                    dis.close();
                    is.close();
                }
                catch(Exception e)
                {
                    System.out.println("File not found");
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
