package bloom;

import method.HashFunction;

public class BloomFilter {
    private final int size;
    private BitSet bitSet;
    private final HashFunction[] hashFunctions;

    public BloomFilter(int size, HashFunction[] hashFunctions) {
        this.size = size;
        this.bitSet = new BitSet(size);
        this.hashFunctions = hashFunctions;
    }

    public void add(String word) {
        for (HashFunction hashFunction : hashFunctions) {
            int index = Math.abs(hashFunction.hash(word)) % size;
            this.bitSet.set(index);
        }
    }

    public boolean contains(String word) {
        for (HashFunction hashFunction : hashFunctions) {
            int index = Math.abs(hashFunction.hash(word)) % size;
            if (!this.bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

}
