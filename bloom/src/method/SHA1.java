package method;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 implements HashFunction {
    @Override
    public int hash(String word) {
        try {
            // Create an instance of the SHA-1 algorithm
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Compute the hash value for the input string
            md.update(word.getBytes());
            byte[] digest = md.digest();

            // Convert the hash value to an integer
            BigInteger bigInt = new BigInteger(1, digest);

            return bigInt.intValue();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
