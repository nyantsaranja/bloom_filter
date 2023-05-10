package method;

import org.bouncycastle.crypto.digests.Blake2bDigest;

import java.math.BigInteger;

public class Blake2Hash implements HashFunction{
    @Override
    public int hash(String input) {
        Blake2bDigest blake2b = new Blake2bDigest();
        byte[] data = input.getBytes();
        blake2b.update(data, 0, data.length);
        byte[] hash = new byte[blake2b.getDigestSize()];
        blake2b.doFinal(hash, 0);

        // Convert the hash value to an integer
        BigInteger bigInt = new BigInteger(1, hash);

        return bigInt.intValue();
    }
}
