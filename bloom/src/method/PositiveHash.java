package method;

public class PositiveHash implements HashFunction {
    private final HashFunction hashFunction;

    public PositiveHash(HashFunction hashFunction) {
        this.hashFunction = hashFunction;
    }

    @Override
    public int hash(String word) {
        int hash = hashFunction.hash(word);
        return (hash >= 0) ? hash : -hash;
    }
}

