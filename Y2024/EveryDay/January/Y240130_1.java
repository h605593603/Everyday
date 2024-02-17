package Y2024.EveryDay.January;

import java.util.*;

public class Y240130_1 {
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, Integer> beforePos = new HashMap<>();
        Map<Integer, Integer> maxLen = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            Integer cur = nums.get(i);
            if (beforePos.containsKey(cur)) {
                int tmpLen = i - beforePos.get(cur);
                beforePos.put(cur, i);
                maxLen.put(cur, Math.max(tmpLen, maxLen.getOrDefault(cur, 0)));
            } else {
                beforePos.put(cur, i);
            }
        }

        int maxDiff = nums.size();
        for (Map.Entry<Integer, Integer> entry : maxLen.entrySet()) {
            maxDiff = Math.min(maxDiff, entry.getValue());
        }

        return maxDiff / 2;
    }

    public static void main(String[] args) {
        Y240130_1 y2401301 = new Y240130_1();
        List<Integer> nums = Arrays.asList(new Integer[]{1, 2, 1, 2});

        System.out.println(y2401301.minimumSeconds(nums));
    }
}
