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

    public void reset() {
        // Faire un clear pour chacun des bits settés
        for(int i=0; i<this.size; i++){
            if(this.bitSet.get(i))
                this.bitSet.clear(i);
        }
    }

    public int count() {
        // Compter le nombre de bits settés à 1
        int nbSet = 0;
        for(int i=0; i<this.size; i++){
            if(this.bitSet.get(i))
                nbSet++;
        }

        // Estimer le nombre d'items insérés: formule trouvée dans la référence suivante
        // Reference: https://en.wikipedia.org/wiki/Bloom_filter
        return (int)Math.round(-this.size * (Math.log(1 - 1.0*nbSet/this.size))/(this.hashFunctions.length));
    }

        public double getFalsePositiveRate(Integer nbWords) {
            if (nbWords == null) nbWords = count();
            if (this.size==0) { // Pour gérer une éventuelle division par 0
                return 0;
            } else {

                // fpp = (1-exp(-kn/m)^k)
                double result = Math.pow((1 - Math.exp(-1.0*(this.hashFunctions.length * nbWords)/this.size)), this.hashFunctions.length);

                // Précision de 6 décimals
                return (double)Math.round(result * 1000000d) / 1000000d;
            }
        }

}
