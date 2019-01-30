/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileencrypt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;

public class FileEnCrypt {
    


    public static void main(String[] args) {
        // TODO code application logic here
        try {
            FileInputStream fis = new FileInputStream("D:/file/pubKey.bin");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();
            X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = factory.generatePublic(spec);
            //
            // Encrypt data
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.ENCRYPT_MODE, pubKey);
            //
            //-----------------------------------------------------------------------------------------
            //
            File fin = new File("D:/message.txt");
            FileInputStream fis1 = null;
            String str = "";
            try {
                fis1 = new FileInputStream(fin);
                int content;
                while ((content = fis1.read()) != -1) {
                    // convert to char and display it
                    str += (char) content;
                }
            } catch (IOException e) {
                e.printStackTrace();
                //chuyển file vào string
                //--------------------------------------------------------------------
            } finally {
                try {
                    if (fis1 != null) {
                        fis1.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            byte encryptOut[] = c.doFinal(str.getBytes());
            String strEncrypt = Base64.getEncoder().encodeToString(encryptOut);
            System.out.println("String result: " + strEncrypt);
            FileOutputStream fos = new FileOutputStream("D:/encrypt.txt");
            fos.write(strEncrypt.getBytes());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
