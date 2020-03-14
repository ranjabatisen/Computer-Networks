/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
/**
 *
 * @author student
 */
public class BufferedInputStreamDemo {
     public static void main(String args[])throws IOException
    {
        FileInputStream fin=new FileInputStream("C:/Users/student/Desktop/csec_148/abc.txt");
        BufferedInputStream bin=new BufferedInputStream(fin);
        System.out.println("No. of remaining bytes:" +bin.available());
        boolean b=bin.markSupported();
        if(b)
        {
            bin.mark(bin.available());
        }
        bin.skip(4);
        System.out.println("FileContents :");
        int ch;
        while((ch=bin.read())!=-1)
        {
            System.out.println((char)ch);
        }
        bin.reset();
        while((ch=bin.read())!=-1)
        {
            System.out.println((char)ch);
        }
        fin.close();
    }
}
