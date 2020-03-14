/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day7;
import java.io.*;
import java.net.*;
class read2 implements Runnable
{
    Thread t; Socket skt;String msg;BufferedReader inC;
    read2(Socket s)throws Exception
    {
        t=new Thread(this,"ReadFromClient");
        System.out.println("Thread created"+t.getName());
        skt=s;
        inC=new BufferedReader(new InputStreamReader(skt.getInputStream()));
        t.start();
    }
    public void run()
    {
        while(true)
        {
            try
            {
                msg=inC.readLine();
                if(msg.equals("Bye"))
                {
                    skt.close();
                    System.exit(0);
                }
                System.out.println("From Client: "+msg);
                //t.sleep(1000);
                }  
            catch(Exception e){}
        }  
    }
}
class write2 implements Runnable
{
   Thread t; Socket skt;String msg;BufferedReader br; 
   DataOutputStream outC;
   write2(Socket s)throws Exception
    {
        t=new Thread(this,"WriteToClient");
        System.out.println("Thread created"+t.getName());
        skt=s;
        br=new BufferedReader(new InputStreamReader(System.in));
        outC=new DataOutputStream(skt.getOutputStream());
        t.start();
   }
    public void run()
    {
        while(true)
        {
            try
            {
                System.out.println("Server->enter msg: ");
                msg=br.readLine();
                outC.writeBytes(msg+"\n");
                if(msg.equals("Bye"))
                {
                    skt.close();
                    System.exit(0);
                }
                //t.sleep(1000);
                }  
            catch(Exception e){}
        }  
    }
}
public class tcp_chat_server {
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ServerSocket skt=new ServerSocket(5050);
        Socket con=skt.accept();  
        try
        {
            new read2(con);
            new write2(con);
        }
        catch(Exception e){}
    }
}
 
