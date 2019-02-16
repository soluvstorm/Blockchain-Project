/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asymmetrickey;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.imageio.IIOException;

/**
 *
 * @author DELL
 */
public class AsymmetricKey {

    public static class ReturningKeyPair {

        private PublicKey pubKey;
        private PrivateKey priKey;

        public ReturningKeyPair(PublicKey pubKey, PrivateKey priKey) {
            this.pubKey = pubKey;
            this.priKey = priKey;
        }
    }

    public static ReturningKeyPair asymmetricKeyGeneration() throws IOException, NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        PublicKey pubKey = keyPair.getPublic();
        PrivateKey priKey = keyPair.getPrivate();

        ReturningKeyPair rKeyPair = new ReturningKeyPair(pubKey, priKey);
        rKeyPair.pubKey = pubKey;
        rKeyPair.priKey = priKey;

        return rKeyPair;

    }

    public static byte[] asymmetricEncryption(String data, PublicKey publicKey) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] byteEncrypted = cipher.doFinal(data.getBytes());

        return byteEncrypted;
    }

    public static byte[] asymmetricDecrpytion(byte[] byteEncrypted, PrivateKey priKey) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        byte[] byteDecrypted = cipher.doFinal(byteEncrypted);
        return byteDecrypted;

    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        // TODO code application logic here
        ReturningKeyPair rKeyPair = asymmetricKeyGeneration();
        //generate key pair
        PublicKey publicKey = rKeyPair.pubKey;
        PrivateKey privateKey = rKeyPair.priKey;
        //encrypt public key
        String data = "Ngo Vinh Hien";
        byte[] byteEncrypted = asymmetricEncryption(data, publicKey);
        String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);
        System.out.println("encrpyted:" + encrypted);

        byte[] byteDecrypted = asymmetricDecrpytion(byteEncrypted, privateKey);
        String decrypted = new String(byteDecrypted);
        System.out.println("decrypted: " + decrypted);

    }

}
