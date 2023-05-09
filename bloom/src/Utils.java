import java.util.List;

public class Utils {

    public static int countEqualsElements(List<String> list1, List<String> list2) {
        int count = 0;
        for (String element : list1) {
            if (list2.contains(element)) {
                count++;
            }
        }
        return count;
    }
}
