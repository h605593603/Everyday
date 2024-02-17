package Y2024.EveryDay.January;

import java.util.HashSet;
import java.util.Set;

public class Y240117_1 {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> strSet = new HashSet<>();
        int result = 0;

        for (String curStr : words) {
            if (strSet.contains(curStr)) {
                result++;
                strSet.remove(curStr);
            } else {
                strSet.add(new StringBuffer(curStr).reverse().toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Y240117_1 y2401171 = new Y240117_1();
        String[] words = {"cd","ac","dc","ca","zz"};
        System.out.println(y2401171.maximumNumberOfStringPairs(words));
    }
}
