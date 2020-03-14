/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author student
 */
public class TestDataOutput {
    public static void main(String args[])throws IOException
    {
        String strFile="C:/Users/student/Desktop/csec_148/file.txt";
        FileOutputStream fos= new FileOutputStream(strFile);
        DataOutputStream dos= new DataOutputStream(fos);
        String num="100";
        dos.writeUTF(num);
        dos.flush();
        dos.close();
        fos.close();
        System.out.println("Done");
    }
}
