package method;

public class IntHashFunction implements HashFunction {
    public int hash(String word) {
        int val;
        // Convertir la chaîne de caractères en un entier

        val = word.hashCode();


        return val % 1000000; // Choisissez un grand nombre premier pour votre filtre de Bloom
    }
}


