/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day7;
import java.io.*;
import java.net.*;
class read implements Runnable
{
    Thread t; Socket skt;String msg;BufferedReader inS;
    read(Socket s)throws Exception
    {
        t=new Thread(this,"ReadFromServer");
        System.out.println("Thread created"+t.getName());
        skt=s;
        inS=new BufferedReader(new InputStreamReader(skt.getInputStream()));
        t.start();
    }
    public void run()
    {
        while(true)
        {
            try
            {
                msg=inS.readLine();
                if(msg.equals("Bye"))
                {
                    skt.close();
                    System.exit(0);
                }
                System.out.println("From Server: "+msg);
                //t.sleep(1000);
                }  
            catch(Exception e){}
        }  
    }
}
class write implements Runnable
{
   Thread t; Socket skt;String msg;BufferedReader br; 
   DataOutputStream outS;
   write(Socket s)throws Exception
    {
        t=new Thread(this,"WriteToServer");
        System.out.println("Thread created"+t.getName());
        skt=s;
        br=new BufferedReader(new InputStreamReader(System.in));
        outS=new DataOutputStream(skt.getOutputStream());
        t.start();
   }
    public void run()
    {
        while(true)
        {
            try
            {
                System.out.println("Client->enter msg: ");
                msg=br.readLine();
                outS.writeBytes(msg+"\n");
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
public class tcp_chat_client {
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Socket skt=new Socket("localhost",5050);
        Thread t1;
        t1=new Thread();
        try
        {
            t1.start();
            new read(skt);
            new write(skt);
        }
        catch(Exception e){}
    }
 }
