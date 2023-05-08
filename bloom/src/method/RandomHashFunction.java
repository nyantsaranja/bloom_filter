package method;

import java.util.Random;

public class RandomHashFunction implements HashFunction {
    private Random rand;

    public RandomHashFunction() {
        rand = new Random();
    }

    public int hash(String word) {
        rand.setSeed(word.hashCode());
        return rand.nextInt();
    }
}

