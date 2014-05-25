package com.cimplist.cip.security;

import java.security.InvalidKeyException;
import java.security.Key;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;

import org.springframework.security.crypto.codec.Base64;

public class SymmetricKeyKrypto {

	private static String algorithm = "DESede";
    private static Key key = null;
    private static Cipher cipher = null;

    private static void setUp() throws Exception {
        key = KeyGenerator.getInstance(algorithm).generateKey();
        cipher = Cipher.getInstance(algorithm);
    }

    public static void main(String[] args) 
       throws Exception {
        setUp();
        
        byte[] pkey = key.getEncoded();
        
        String privateKey = encodeBase64(pkey);        
        System.out.println("Private Key: " + privateKey);
        
        byte[] pkey2=decodeBase64(privateKey);
        

        String input = "sanjay singh";
        System.out.println("Entered: " + input);
        byte[] encryptionBytes = encrypt(input);

  
        String encoded = encodeBase64(encryptionBytes);
        System.out.println("Encrypted Data: "+encoded);
        byte[] decrypt =  decodeBase64(encoded);
        	       
        System.out.println("Recovered: " + decrypt(decrypt));
    }

    public static byte[] encrypt(String input)
        throws InvalidKeyException, 
               BadPaddingException,
               IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] inputBytes = input.getBytes();
        return cipher.doFinal(inputBytes);
    }

    public static String decrypt(byte[] encryptionBytes)
        throws InvalidKeyException, 
               BadPaddingException,
               IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] recoveredBytes =  cipher.doFinal(encryptionBytes);
        String recovered =  new String(recoveredBytes);
        return recovered;
      }
    public static String encodeBase64(byte[] encryptionBytes){
        byte[] cryptBase64=Base64.encode(encryptionBytes);
        String cryptb64text=new String(cryptBase64);
      
        return cryptb64text;
    }
    public static byte[] decodeBase64(String encodedB64text){
    	   byte[] decoded = Base64.decode(encodedB64text.getBytes());
    	   return decoded;
    }
}


