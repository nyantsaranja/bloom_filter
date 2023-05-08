package bloom;

import method.HashFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BloomFilterBoolean {

    private final int size;
    private boolean[] filter; // le tableau de bits
    private final HashFunction[] hashFunctions; // la liste des fonctions de hachage

    public BloomFilterBoolean(int size, HashFunction[] hashFunctions) {
        this.size = size;
        this.filter = new boolean[size];
        this.hashFunctions = hashFunctions;
    }

    public void clear() {
        Arrays.fill(filter, false); // réinitialisez toutes les valeurs du tableau de bits à false
    }

    public void add(String word) {
        for (HashFunction hashFunction : hashFunctions) {
            int hash = Math.abs(hashFunction.hash(word)) % size;
            filter[hash] = true; // modifier la valeur dans le tableau de bits
        }
    }

    public boolean contains(String word) {
        for (HashFunction hashFunction : hashFunctions) {
            int hash = Math.abs(hashFunction.hash(word)) % size;
            if (!filter[hash]) {
                return false; // si la valeur correspondante dans le tableau de bits est à false, le mot n'est pas présent
            }
        }
        return true; // toutes les valeurs correspondantes dans le tableau de bits sont à true, le mot est probablement présent
    }
}
