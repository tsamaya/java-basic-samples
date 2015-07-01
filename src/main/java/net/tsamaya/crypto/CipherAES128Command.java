package net.tsamaya.crypto;

/**
 * Created by aferrand on 01/07/2015.
 */

public class CipherAES128Command {

    public static final String crypt = "crypt";
    public static final String decrypt = "decrypt";

    private static final int ARG_COMMAND = 0;
    private static final int ARG_VALUE = 1;
    private static final int ARG_KEY = 2;
    private static final int ARG_RANDOM = 3;

    public static void main(String args[]) {
        System.out.println(args.length + "args.length");
        for(int i = 0; i < args.length; i++) {
            System.out.println(i+" "+args[i]);
        }
        if (args.length <= 1) {
            usage();
            return;
        }
        if( crypt.equalsIgnoreCase(args[ARG_COMMAND])) {
            if( args.length > 3) {
                System.out.println("Crypted value is : " + CipherAES128.encryptWithPrefix(args[ARG_KEY], args[ARG_RANDOM], args[ARG_VALUE]));
            } else {
                System.out.println("Crypted value is : " + CipherAES128.encryptWithPrefix(args[ARG_VALUE]));
            }
        } else if( decrypt.equalsIgnoreCase(args[ARG_COMMAND])) {
            if( args.length > 3) {
                System.out.println("Decrypted value is : " + CipherAES128.decrypt(args[ARG_KEY], args[ARG_RANDOM], args[ARG_VALUE]));
            } else {
                System.out.println("Decrypted value is : " + CipherAES128.decrypt(args[ARG_VALUE]));
            }
        } else {
            usage();
        }
    }

    private static void usage() {
        System.out.println("Usage:");
        System.out.println("\tjava net.tsamaya.crypto.CipherAES128Command crypt value [key1 key2] ");
        System.out.println("\tjava net.tsamaya.crypto.CipherAES128Command decrypt value [key1 key2] ");

    }
}
