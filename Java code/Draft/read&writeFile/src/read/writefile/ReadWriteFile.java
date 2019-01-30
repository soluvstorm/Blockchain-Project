/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package read.writefile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
/**
 *
 * @author DELL
 */
public class ReadWriteFile {

    /**
     * @param args the command line arguments
     */
        private static final String path = "D:/message.txt";

    public static void main(String[] args) {
        // TODO code application logic here
        
//        FileInputStream input = null;
//        try {
//            File file = new File("D:/aaab.txt");
//            input = new FileInputStream(file);
//            System.out.println("byte cua file file: " + input.available());
//
//        } catch (IOException ex) {
//            System.out.println("ko co file");
//        }
//        try {
//            int noidung;
//            while ((noidung = input.read()) != -1) {
//                //for(int i = 0 ; i <= input.available(); i++ ){
//                System.out.print((char) noidung);
//            }
//
//        } catch (IOException ex) {
//            System.out.println("ko co file");
//        }
       //byte[] a = new byte[input.available()];
        //System.out.println(a);


       Scanner sc = new Scanner(System.in);
       String test;
       System.out.println("Nhap test: ");
       test = sc.nextLine(); 
       System.out.println("Vua moi nhap: "+test);

       try{
           FileOutputStream output = new FileOutputStream(path,true);
           
           output.write(test.getBytes());
           System.out.println("da viet");
       } catch(IOException ex){
           System.out.println("fall");
       }
        
        
    }
    
}
