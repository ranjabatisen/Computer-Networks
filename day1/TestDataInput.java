/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1;
import java.io.*;
import java.io.IOException;
/**
 *
 * @author student
 */
public class TestDataInput {
    public static void main(String args[])throws IOException
    {
        String strFile="C:/Users/student/Desktop/csec_148/file.txt";
        FileInputStream fos= new FileInputStream(strFile);
        DataInputStream dos= new DataInputStream(fos);
        String num;
        num=dos.readUTF();
        dos.close();
        fos.close();
        System.out.println("Done"+num);
    }
}
