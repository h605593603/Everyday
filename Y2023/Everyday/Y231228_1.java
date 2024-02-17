package Y2023.Everyday;

public class Y231228_1 {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[] f = new int[n];
        System.arraycopy(nums, 0, f, 0, n);
        long ans = getSum(f);
        for (int k = 1; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                f[i] = Math.min(f[i], nums[(i + k) % n]);
            }
            ans = Math.min(ans, (long) k * x + getSum(f));
        }
        return ans;
    }

    public long getSum(int[] f) {
        long sum = 0;
        for (int num : f) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        Y231228_1 y2312281 = new Y231228_1();
        int[] nums = {20,1,15};
        int x = 5;
        System.out.println(y2312281.minCost(nums, x));
    }
}
