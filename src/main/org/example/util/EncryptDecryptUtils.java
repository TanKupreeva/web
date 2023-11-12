package main.org.example.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptDecryptUtils {
    private static final String SECRET_KEY_1 = "Users_APP1234567";
    private static final String SECRET_KEY_2 = "fsxfweJiSEvR5yAC";

    private static IvParameterSpec ivParameterSpec;
    private static SecretKeySpec secretKeySpec;
    private static Cipher cipher;

    static {
        try {
            ivParameterSpec = new IvParameterSpec(SECRET_KEY_1.getBytes("UTF-8"));
            secretKeySpec = new SecretKeySpec(SECRET_KEY_2.getBytes("UTF-8"), "AES");
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (NoSuchPaddingException e) {
                throw new RuntimeException(e);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Encrypt the string with this internal algorithm.
     *
     * @param toBeEncrypt string object to be encrypt.
     * @return returns encrypted string.
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String encrypt(String toBeEncrypt) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(toBeEncrypt.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Decrypt this string with the internal algorithm. The passed argument should be encrypted using
     * {@link #encrypt(String) encrypt} method of this class.
     *
     * @param encrypted encrypted string that was encrypted using {@link #encrypt(String) encrypt} method.
     * @return decrypted string.
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String decrypt(String encrypted) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] decryptedBytes = cipher.doFinal(Base64.decodeBase64(encrypted));
            return new String(decryptedBytes);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws UnsupportedEncodingException,
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        String str1 = "hello";
        String encryptedStr1 = EncryptDecryptUtils.encrypt(str1);
        System.out.println("Encrypted: " + encryptedStr1);
        String str2 = EncryptDecryptUtils.decrypt(encryptedStr1);
        System.out.println("decrypted: " + str2);
        System.out.println(str1 == str2);
    }

}
