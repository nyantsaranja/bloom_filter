package method;

public class FNVHash implements HashFunction {
    private final int p = 16777619;

    @Override
    public int hash(String word) {
        int hash = 216613626;
        for (int i = 0; i < word.length(); i++) {
            hash = (hash * p) ^ word.charAt(i);
        }
        return hash;
    }
}

