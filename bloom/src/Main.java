import bloom.BloomFilter;
import bloom.BloomFilterBoolean;
import method.*;

import java.util.List;

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
                new MD5Hash(),
                new SHA1(),
                new Blake2Hash()
        };

        // Création du filtre de Bloom
        int filterSize = 1000000;
//        BloomFilterBoolean bloomFilter = new BloomFilterBoolean(filterSize, hashFunctions);
        BloomFilter bloomFilter = new BloomFilter(filterSize, hashFunctions);

        // Ajout de mots au filtre de Bloom
        List<String> passwordsToAdd=PasswordGenerator.readPasswordsFromFile("passwords.txt");
        for (String word : passwordsToAdd) {
            bloomFilter.add(word);
        }

        // Test de la présence de mots dans le filtre de Bloom
        List<String> passwordsToTest=PasswordGenerator.readPasswordsFromFile("passwords2.txt");
        int positive = 0;
        for (String word : passwordsToTest) {
            boolean isPresent = bloomFilter.contains(word);
            if (isPresent) {
                positive ++;
            }
        }
        System.out.println("Nombre de mots présents : " + positive + "/" + passwordsToTest.size());
        System.out.println("False positive rate: " + bloomFilter.getFalsePositiveRate(passwordsToAdd.size()));
//        System.out.println("Nombre de vrais positifs:" + Utils.countEqualsElements(passwordsToAdd,passwordsToTest));
    }
}
