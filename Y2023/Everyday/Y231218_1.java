package Y2023.Everyday;

public class Y231218_1 {
    public int findPeakElement(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = Integer.MIN_VALUE;
        newNums[nums.length +  1] = Integer.MIN_VALUE;
        System.arraycopy(nums, 0, newNums, 1, nums.length);

        for (int i = 1; i < newNums.length - 1; i++) {
            if (newNums[i] >= newNums[i - 1] && newNums[i] >= newNums[i + 1]) {
                return i - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Y231218_1 y2312181 = new Y231218_1();
        int[] nums = {1,2,3,1};
        System.out.println(y2312181.findPeakElement(nums));
    }
}
