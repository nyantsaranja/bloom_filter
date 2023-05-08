import bloom.BloomFilter;
import bloom.BloomFilterBoolean;
import method.*;

public class Main {

//    public static void main(String[] args) {
//        String test = "aaa";
//        System.out.println("string hash : " + new StringHashFunction().hash(test));
//        System.out.println("int hash : " +new IntHashFunction().hash(test));
//        System.out.println("rand hash : " +new RandomHashFunction().hash(test));
//        System.out.println("simple hash : " +new SimpleHash(100023).hash(test));
//        System.out.println("fnv hash : " +new FNVHash().hash(test));
//        System.out.println("murmur hash : " +new MurmurHash().hash(test));
//        //taille d'un boolean
//        System.out.println("boolean size : " + Boolean.TRUE.hashCode() );
//    }

    public static void main(String[] args) {
        // Création des fonctions de hachage
        HashFunction[] hashFunctions = {
                new SimpleHash(),
                new FNVHash(),
                new MurmurHash()
        };

        // Création du filtre de Bloom
        int filterSize = 1000000000;
//        BloomFilterBoolean bloomFilter = new BloomFilterBoolean(filterSize, hashFunctions);
        BloomFilter bloomFilter = new BloomFilter(filterSize, hashFunctions);

        // Ajout de mots au filtre de Bloom
        String[] wordsToAdd = {"hello", "world", "foo", "bar", "baz", "Qux"};
        for (String word : wordsToAdd) {
            bloomFilter.add(word);
        }

        // Test de la présence de mots dans le filtre de Bloom
        String[] wordsToTest = {"hello", "world", "foo", "bar", "baz", "qux", "quux"};
        for (String word : wordsToTest) {
            boolean isPresent = bloomFilter.contains(word);
            if (isPresent) {
                System.out.println(word + " is probably in the filter.");
            } else {
                System.out.println(word + " is definitely not in the filter.");
            }
        }
    }
}
