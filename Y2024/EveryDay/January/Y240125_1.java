package Y2024.EveryDay.January;

import java.util.Arrays;
import java.util.List;

public class Y240125_1 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int left = (1 << k) - 1;
        int result = 0;

        if (k == 0) {
            return nums.get(0);
        }
        while (left < nums.size()) {
            result += nums.get(left);

            int lowBit = left & -left;
            int newLeft = left + lowBit;
            left = (((newLeft ^ left) >> 2) / lowBit) | newLeft;
        }
        return result;
    }

    public static void main(String[] args) {
        Y240125_1 y2401251 = new Y240125_1();
        List<Integer> nums = Arrays.asList(new Integer[]{4,3,2,1});
        int k = 2;
        System.out.println(y2401251.sumIndicesWithKSetBits(nums, k));
    }
}
