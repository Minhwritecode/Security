package Security;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class SecurityRSABĐX {
    public static void main(String[] args) {
        String plainText = "Hello, world!"; // Văn bản cần mã hoá

        try {
            // Khởi tạo đối tượng KeyPairGenerator với thuật toán RSA
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048); // Đặt độ dài khóa RSA là 2048 bit

            // Tạo cặp khóa (khóa riêng và khóa công khai)
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            // Mã hoá văn bản bằng khóa công khai
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = encryptCipher.doFinal(plainText.getBytes());

            // Giải mã văn bản bằng khóa riêng
            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = decryptCipher.doFinal(encryptedBytes);

            // Chuyển đổi byte thành chuỗi
            String decryptedText = new String(decryptedBytes);

            // In kết quả giải mã
            System.out.println("Văn bản sau khi giải mã: " + decryptedText);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}