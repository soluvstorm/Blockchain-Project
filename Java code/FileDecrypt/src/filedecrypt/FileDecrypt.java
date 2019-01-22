/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedecrypt;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;


/**
 *
 * @author DELL
 */
import javax.crypto.Cipher;
public class FileDecrypt {

    public static void main(String[] args) {
        // TODO code application logic here
         try {
            // read file containing private key
            FileInputStream fis = new FileInputStream("D:/file/priKey.bin");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();
// create private key
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = factory.generatePrivate(spec);

            // decrypt
            String decrypt = null;
            FileInputStream fis2 = new FileInputStream("D:/encrypt.txt");
            byte[] en = new byte [fis2.available()];
            
            
            String str="";
            
            int content;
             while ((content = fis2.read()) != -1) {
                 // convert to char and display it
                 str += (char) content;
             }
             

            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, priKey);
            byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(
                    str));
            System.out.println("Data decrypted: " + new String(decryptOut));
        }  catch (Exception ex) {
            ex.printStackTrace();
        }
                   
    }
    
}
