package Security;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class SecuritySHA {
	    public static void main(String[] args) {
	        String input = "Hello, world!"; // Chuỗi cần mã hoá SHA

	        try {
	            // Khởi tạo đối tượng MessageDigest với thuật toán SHA-256
	            MessageDigest sha = MessageDigest.getInstance("SHA-256");

	            // Chuyển đổi chuỗi thành mảng byte
	            byte[] inputBytes = input.getBytes();

	            // Áp dụng mã hoá SHA-256 lên mảng byte
	            byte[] hashedBytes = sha.digest(inputBytes);

	            // Chuyển đổi mảng byte thành dạng hex string
	            StringBuilder hexString = new StringBuilder();
	            for (byte b : hashedBytes) {
	                String hex = Integer.toHexString(0xff & b);
	                if (hex.length() == 1) {
	                    hexString.append('0');
	                }
	                hexString.append(hex);
	            }

	            // In kết quả mã hoá SHA
	            System.out.println("Michael 0308: " + hexString.toString());
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	    }
	}
