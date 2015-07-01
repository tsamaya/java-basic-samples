package net.tsamaya.crypto;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aferrand on 01/07/2015.
 */
public class CipherAESTest {


    String key1 = "AbCdEfGhIjK12345"; // 128 bit key
    String key2 = "ThisIsASecretKey";
    String hello = "Hello World";

    @Test
    public void CipherAES128() {
        CipherAES128 exists = new CipherAES128();
    }

    @Test
    public void testEncryptDecrypt() {
        Assert.assertEquals(hello, CipherAES128.decrypt(key1, key2,
                CipherAES128.encrypt(key1, key2, hello)));
    }

    @Test
    public void testEncrypt() {
        String encrypted = CipherAES128.encrypt(key1, key2, hello);
        System.out.println("Encrypted is " + encrypted);
        Assert.assertEquals("nzgKJz2fR2wivhpCc3tfIg==", encrypted);
    }

    @Test
    public void testEncryptWithPrefix() {
        String encrypted = CipherAES128.encryptWithPrefix(hello);
        System.out.println("Encrypted is " + encrypted);
        Assert.assertEquals("AES128:nzgKJz2fR2wivhpCc3tfIg==", encrypted);
    }

    @Test
    public void testDecrypt() {
        String decrypted = CipherAES128.decrypt(key1, key2, "nzgKJz2fR2wivhpCc3tfIg==");
        System.out.println("Decrypted is " + decrypted);
        Assert.assertEquals(hello, decrypted);

    }

    @Test
    public void testDecryptWithPrefix() {
        String decrypted = CipherAES128.decrypt(key1, key2, "AES128:nzgKJz2fR2wivhpCc3tfIg==");
        System.out.println("Decrypted is " + decrypted);
        Assert.assertEquals(hello, decrypted);

    }

    @Test
    public void testEncDecIntern() {
        Assert.assertEquals(hello, CipherAES128.decrypt(CipherAES128.encrypt(hello)));
    }

    @Test
    public void testEncryptIntern() {
        String encrypted = CipherAES128.encrypt(hello);
        System.out.println("Encrypted is " + encrypted);
        Assert.assertEquals("nzgKJz2fR2wivhpCc3tfIg==", encrypted);
    }

    @Test
    public void testDecryptIntern() {
        String decrypted = CipherAES128.decrypt("nzgKJz2fR2wivhpCc3tfIg==");
        System.out.println("Decrypted is " + decrypted);
        Assert.assertEquals(hello, decrypted);
    }

    @Test
    public void testEncryptException() {
        String key = "123";
        Assert.assertNull(CipherAES128.encrypt(key, key, hello));
    }

    @Test
    public void testDecryptException() {
        String key = "123";
        Assert.assertNull(CipherAES128.decrypt(key, key, hello));
    }

}
