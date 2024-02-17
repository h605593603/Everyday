package Y2024.EveryDay.January;

import java.util.HashMap;
import java.util.Map;

public class Y240112_1 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> words1Map = new HashMap<>();
        Map<String, Integer> words2Map = new HashMap<>();
        int result = 0;

        for (String cur : words1) {
            words1Map.put(cur, words1Map.getOrDefault(cur, 0) + 1);
        }

        for (String cur : words2) {
            words2Map.put(cur, words2Map.getOrDefault(cur, 0) + 1);
        }
        /* 遍历Map */
        for (Map.Entry<String, Integer> entry : words1Map.entrySet()) {
            if (entry.getValue() == 1 && words2Map.getOrDefault(entry.getKey(), 0) == 1) {
                result++;
            }
        }
        /* 遍历数组 */
        for (String cur : words1) {
            if (words1Map.get(cur) == 1 && words2Map.getOrDefault(cur, 0) == 1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Y240112_1 y2401121 = new Y240112_1();
        String[] words1 = {"leetcode","is","amazing","as","is"};
        String[] words2 = {"amazing","leetcode","is"};
        System.out.println(y2401121.countWords(words1, words2));
    }
}
