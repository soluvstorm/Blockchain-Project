package symmetrickey;


import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;



public class SymmetricKey {


 public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException{
     
     SecretKey secretKey2 = symmetricKeyGeneration();
     System.out.println("secretkey2:"+secretKey2);
     
     
     String data = "Tran Hoang Chuong";
     String byteEncrypted = symmetricEncryption(data, secretKey2);
     
     System.out.println("byte encrypted symm: "+byteEncrypted);
     
     String dataDecrypted = symmetricDecryption(byteEncrypted, secretKey2);
     System.out.println("data decrypted: "+ dataDecrypted);
     

     
 }

    public static SecretKey symmetricKeyGeneration()throws IOException, NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede"); // generates secrey ket for specified algorithm
        keyGenerator.init(168); // set size
        SecretKey secretKey = keyGenerator.generateKey(); // put the generated secret key to the specified 
        
      return secretKey;
    }
    
    public static String  symmetricEncryption(String data,SecretKey secretKey) throws IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException{
        
        Cipher cipher = null;
        cipher = Cipher.getInstance("DESede");
        cipher.init(cipher.ENCRYPT_MODE,secretKey);
        byte[] byteEncrypted = cipher.doFinal(data.getBytes());
        String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);
        
        return encrypted;
        
        
    }
    
    public static String symmetricDecryption(String dataEncrypted, SecretKey secretKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = null;
        cipher = Cipher.getInstance("DESede");
        cipher.init(cipher.DECRYPT_MODE,secretKey);
        byte[] asd = dataEncrypted.getBytes();
        byte[] dec = Base64.getDecoder().decode(asd);

        byte[] dataDecrypted = cipher.doFinal(dec);
        String decrypted = new String(dataDecrypted);


        
        return decrypted;
    }

}

