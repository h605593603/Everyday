package Y2023.Everyday;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Y231212_1 {
    public int[] secondGreaterElement(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            boolean haveBig = Boolean.FALSE;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i] && !haveBig) {
                    haveBig = Boolean.TRUE;
                } else if (nums[j] > nums[i]) {
                    result[i] = nums[j];
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Y231212_1 y2312121 = new Y231212_1();
        int[] nums = {2,4,0,9,6};
        System.out.println(Arrays.toString(y2312121.secondGreaterElement(nums)));
    }
}
