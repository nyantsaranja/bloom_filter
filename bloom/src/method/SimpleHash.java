package method;

public class SimpleHash implements HashFunction {
    private final int p;

    public SimpleHash(int p) {
        this.p = p;
    }

    @Override
    public int hash(String word) {
        int hash = 0;
        for (int i = 0; i < word.length(); i++) {
            hash = 33 * hash + word.charAt(i);
            hash %= p;
        }
        return hash;
    }
}

