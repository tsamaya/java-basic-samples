package net.tsamaya.crypto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

public class AESTest {
  String hello = "Hello World";
  String password = "Une Belle PassPhrase";

  @Test
  public void testHello() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
      ByteArrayInputStream in = null;
      try {
          in = new ByteArrayInputStream(hello.getBytes("UTF-8"));
          AES.encrypt(128, password.toCharArray(), in, out);
          System.out.println(new String(out.toByteArray()));
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
    } catch (AES.InvalidKeyLengthException e) {
      e.printStackTrace();
    } catch (AES.StrongEncryptionNotAvailableException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
