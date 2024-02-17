package Y2024.EveryDay.January;

public class Y240123_1 {
    public int alternatingSubarray(int[] nums) {
        int result = -1;
        int[] diffNums = new int[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            diffNums[i - 1] = nums[i] - nums[i - 1];
        }

        int head = -1;
        for (int i = 0; i < diffNums.length; i++) {
            /* 寻找头 */
            if (diffNums[i] == 1 && head == -1) {
                head = i;
            }
            if (head !=-1 && diffNums[i] != Math.pow(-1, i - head)) {
                result = Math.max(result, i - head + 1);
                head = -1;
                i--;
            }
        }
        if (head != -1) {
            result = Math.max(result, diffNums.length - head + 1);
        }

        return result == 1 ? -1 : result;
    }

    public static void main(String[] args) {
        Y240123_1 y2401231 = new Y240123_1();
        int[] nums = new int[]{2,3,4,3,4};
        System.out.println(y2401231.alternatingSubarray(nums));
    }
}
