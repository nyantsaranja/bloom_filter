package method;

public class ModuloNHash implements HashFunction {
    private final int n = 2434656;


    @Override
    public int hash(String s) {
        int hash = 0;
        for (char c : s.toCharArray()) {
            hash = (hash * 31 + c) % n;
        }
        return hash;
    }
}

