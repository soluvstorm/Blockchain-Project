/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author DELL
 */
public class Hashing {

    /**
     * @param args the command line arguments
     */
    public static String Hashing(String data) throws NoSuchAlgorithmException {
        String HashedString = null;
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        byte[] bytes = md.digest(data.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        HashedString = sb.toString();
        return HashedString;
    }


public static void main(String[] args) throws NoSuchAlgorithmException {
        // TODO code application logic here
    String data = "Luu Dieu Co";
    String hashedData = Hashing(data);
    System.out.println("string:"+hashedData );
    

        
    }
    
}
