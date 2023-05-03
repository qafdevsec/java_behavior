import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class CipherExample {
    public static void main(String[] args) throws Exception {
        byte[] key = "0123456789abcdef".getBytes();
        byte[] data = "Hello World".getBytes();

        // Generate predictable IV
        IvParameterSpec ivSpec = new IvParameterSpec(new byte[16]);

        // Initialize the cipher in encrypt mode with the predictable IV
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), ivSpec);

        // Encrypt the data
        byte[] encryptedData = cipher.doFinal(data);
        System.out.println("Encrypted data: " + Arrays.toString(encryptedData));

        // Decrypt the data using the predictable IV
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), ivSpec);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        System.out.println("Decrypted data: " + new String(decryptedData));
    }
}
