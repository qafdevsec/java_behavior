import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class CipherExample {
    public static void main(String[] args) throws Exception {
        String plainText = This is a secret message!;
        String encryptionKey = This is a secret key!;

        byte[] key = encryptionKey.getBytes();
        SecretKey secretKey = KeyGenerator.getInstance(AES).generateKey();
        Cipher cipher = Cipher.getInstance(AESCBCPKCS5Padding);
        byte[] iv = new byte[cipher.getBlockSize()];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);  generate random IV

        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        System.out.println(Encrypted Text  + new String(cipherText));

         Decrypt the data
        Cipher decryptCipher = Cipher.getInstance(AESCBCPKCS5Padding);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

        byte[] decryptedText = decryptCipher.doFinal(cipherText);
        System.out.println(Decrypted Text  + new String(decryptedText));
    }
}