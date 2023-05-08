package method;

public class MurmurHash implements HashFunction {
    private final int seed = 0x9747b28c;
    private final int m = 0x5bd1e995;
    private final int r = 24;

    @Override
    public int hash(String word) {
        int hash = seed ^ (word.length() * m);
        int currentIndex = 0;
        while (currentIndex < word.length()) {
            int currentChar = word.charAt(currentIndex);
            currentChar *= m;
            currentChar ^= currentChar >>> r;
            currentChar *= m;
            hash *= m;
            hash ^= currentChar;
            currentIndex++;
        }
        hash *= m;
        hash ^= hash >>> r;
        hash *= m;
        hash ^= hash >>> r;
        return hash;
    }
}

