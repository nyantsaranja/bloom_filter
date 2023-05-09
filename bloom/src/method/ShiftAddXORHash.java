package method;

public class ShiftAddXORHash implements HashFunction {
    @Override
    public int hash(String s) {
        int hash = 0;
        for (char c : s.toCharArray()) {
            hash ^= (hash << 5) + (hash >> 2) + c;
        }
        return hash;
    }
}

