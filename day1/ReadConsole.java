/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1;
import java.io.*;
/**
 *
 * @author student
 */
public class ReadConsole {
    public static void main(String args[])throws IOException
    {
        InputStreamReader cin=null;
        try{
            cin=new InputStreamReader(System.in);
            System.out.println("Enter characters,'q' to quit.");
            char c;
            c=(char)cin.read();
            while(c!='q'){
                System.out.print(c);
                c=(char)cin.read();
            }
        }
        finally{
            if(cin !=null){
                cin.close();
            }
        }
    }
}
