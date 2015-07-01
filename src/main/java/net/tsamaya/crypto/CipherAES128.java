package net.tsamaya.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CipherAES128 {

    /**
     * logger !
     */
    private static final Logger logger = LogManager.getLogger(CipherAES128.class);

    private static final String key = "AbCdEfGhIjK12345"; // 128 bit key
    private static final String random = "ThisIsASecretKey";

    public static  final String prefix = "AES128:";


    public static String encrypt(String value){
        return encrypt(key, random, value);
    }

    public static String encryptWithPrefix(String value) {
        return encryptWithPrefix(key, random, value);
    }

    public static String encryptWithPrefix(String key1, String key2, String value) {
        return String.format("%s%s", prefix, encrypt(key1, key2, value));
    }

    public static String decrypt(String value) {
        return decrypt(key, random, value);
    }

    /**
     * Encrypt with a AES128 bits key
     *
     * @param key1  a 128bits key
     * @param key2  a randomness source
     * @param value the value to encrypt
     * @return the encrypt value:
     */
    public static String encrypt(String key1, String key2, String value) {
        String encryptedString = null;
        try {
            IvParameterSpec iv = new IvParameterSpec(key2.getBytes("UTF-8"));

            SecretKeySpec skeySpec = new SecretKeySpec(key1.getBytes("UTF-8"),
                    "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(value.getBytes());
            encryptedString = Base64.encodeBase64String(encrypted);
            logger.debug("encrypted string: {}", encryptedString);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return encryptedString;
    }

    public static String decrypt(String key1, String key2, String encrypted) {
        String decrypted = null;
        try {
            // check for prefix
            if( encrypted!= null && encrypted.startsWith(prefix)) {
                encrypted = encrypted.substring(prefix.length());
            }
            IvParameterSpec iv = new IvParameterSpec(key2.getBytes("UTF-8"));

            SecretKeySpec skeySpec = new SecretKeySpec(key1.getBytes("UTF-8"),
                    "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
            decrypted = new String(original);
            logger.debug("decrypted string: {}", decrypted);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return decrypted;
    }



}
