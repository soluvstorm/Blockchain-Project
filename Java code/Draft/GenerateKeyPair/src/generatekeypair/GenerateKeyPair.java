/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatekeypair;
import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

/**
 *
 * @author DELL
 */
public class GenerateKeyPair {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
           try {
        SecureRandom sr = new SecureRandom();
    //Thuật toán phát sinh khóa - Rivest Shamir Adleman (RSA)
     KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
     kpg.initialize(2048, sr);

     //Phát sinh cặp khóa
     KeyPair kp = kpg.genKeyPair();
     //PublicKey
     PublicKey pubKey = kp.getPublic();
     //PrivateKey
     PrivateKey priKey = kp.getPrivate();

     //Lưu Public Key
     FileOutputStream fos = new FileOutputStream("D:/file/pubKey.bin");
     fos.write(pubKey.getEncoded());
     fos.close();

     //Lưu Private Key
     fos = new FileOutputStream("D:/file/priKey.bin");
     fos.write(priKey.getEncoded());
     fos.close();

     System.out.println("Generate key successfully");
    } catch (Exception e) {
     e.printStackTrace();
    }
    }
    
}




