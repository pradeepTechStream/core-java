import java.security.MessageDigest;

public class StringUtil {

    // Applies Sha256 to a string and returns the result.

    public static String applySha256(String input) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Applies sha256 to our input,

            final byte[] hash = digest.digest(input.getBytes("UTF-8"));
            final StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
            for (final byte element : hash) {
                final String hex = Integer.toHexString(0xff & element);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
