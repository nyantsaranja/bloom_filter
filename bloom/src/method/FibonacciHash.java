package method;

public class FibonacciHash implements HashFunction {
    private final int n = 2354655;


    @Override
    public int hash(String s) {
        int hash = n;
        for (char c : s.toCharArray()) {
            hash = (hash * 89) + (int) c;
        }
        return hash;
    }
}
