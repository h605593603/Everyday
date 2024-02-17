package Y2024.EveryDay.January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Y240120_1 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();

        for (String cur : words) {
            int left = 0;
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) == separator && i == 0) {
                    left = 1;
                } else if (cur.charAt(i) == separator) {
                    if (i > left) {
                        result.add(cur.substring(left, i));
                    }
                    left = i + 1;
                } else if (i == cur.length() - 1) {
                    result.add(cur.substring(left, i + 1));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Y240120_1 y2401201 = new Y240120_1();
        List<String> words = Arrays.asList("stars.bars.$");
        char separator = '.';
        System.out.println(Arrays.toString(y2401201.splitWordsBySeparator(words, separator).toArray()));
    }
}
