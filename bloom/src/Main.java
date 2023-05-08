import method.*;

public class Main {

    public static void main(String[] args) {
        String test = "aaa";
        System.out.println("string hash : " + new StringHashFunction().hash(test));
        System.out.println("int hash : " +new IntHashFunction().hash(test));
        System.out.println("rand hash : " +new RandomHashFunction().hash(test));
        System.out.println("simple hash : " +new SimpleHash(100023).hash(test));
        System.out.println("fnv hash : " +new FNVHash().hash(test));
        System.out.println("murmur hash : " +new MurmurHash().hash(test));
    }
}
