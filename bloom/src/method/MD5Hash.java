package method;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash implements HashFunction {

    @Override
    public int hash(String input) {
        try {
            // Create an instance of the MD5 algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Compute the hash value for the input string
            md.update(input.getBytes());
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
