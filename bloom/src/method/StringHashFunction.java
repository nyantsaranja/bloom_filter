package method;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHashFunction implements HashFunction {
    private MessageDigest md;

    public StringHashFunction() {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not supported", e);
        }
    }

    @Override
    public int hash(String word) {
        md.update(word.getBytes());
        byte[] digest = md.digest();
        int hash = 0;
        for (int i = 0; i < 4; i++) {
            hash <<= 8;
            hash |= (digest[i] & 0xFF);
        }
        return hash;
    }
}

