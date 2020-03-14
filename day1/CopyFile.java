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
public class CopyFile {
     public static void main(String args[])throws IOException
    {
        FileReader in= null;
        FileWriter out= null;
        try{
            in=new FileReader("C:/Users/student/Desktop/csec_148/abc.txt");
            out=new FileWriter("C:/Users/student/Desktop/csec_148/abc2.txt");
            int c;
            while((c=in.read())!=-1)
            {
                out.write(c+3);
            }
        }
        finally{
                if(in!=null){
                    in.close();
                }
                if(out!=null)
                {
                    out.close();
                }
                }
    }
    
}
