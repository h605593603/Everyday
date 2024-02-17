package Y2024.EveryDay.January;

import java.util.*;

public class Y240131_1 {
    public int[] distinctDifferenceArray(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int cur : nums) {
            numsMap.put(cur, numsMap.getOrDefault(cur, 0) + 1);
        }

        int[] result = new int[nums.length];
        Set<Integer> leftSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            leftSet.add(nums[i]);
            if (numsMap.get(nums[i]) > 1 ) {
                result[i] = leftSet.size() - numsMap.size();
                numsMap.put(nums[i], numsMap.get(nums[i]) - 1);
            } else {
                numsMap.remove(nums[i]);
                result[i] = leftSet.size() - numsMap.size();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Y240131_1 y2401311 = new Y240131_1();
        int[] nums = new int[]{3,2,3,4,2};

        System.out.println(Arrays.toString(y2401311.distinctDifferenceArray(nums)));
    }
}
