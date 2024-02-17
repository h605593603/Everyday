package Y2023.MoreOne;

public class Y231203_First_1 {
    /* 自己给的错误解 */
//    public String optimalDivision(int[] nums) {
//        int num = nums.length;
//        StringBuffer result = new StringBuffer(nums[0] + "");
//        if (num > 1) {
//            result.append("/");
//            /* 偶数个 */
//            if (num % 2 == 0) {
//                int left = 0;
//                for (int i = 1; i < num - 2; i++) {
//                    result.append("(");
//                    result.append(nums[i]);
//                    result.append("/");
//                    left++;
//                }
//                result.append(nums[num - 2]);
//                result.append("/");
//                result.append(nums[num - 1]);
//                result.append(")".repeat(Math.max(0, left)));
//            } else {
//                /* 奇数个 */
//                int left = 0;
//                for (int i = 1; i < num - 1; i++) {
//                    result.append("(");
//                    result.append(nums[i]);
//                    result.append("/");
//                    left++;
//                }
//                result.append(nums[num - 1]);
//                result.append(")".repeat(Math.max(0, left)));
//            }
//        }
//        return result.toString();
//    }

    /* 官方正解 */
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return String.valueOf(nums[0]);
        }
        if (n == 2) {
            return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        }
        StringBuffer res = new StringBuffer();
        res.append(nums[0]);
        res.append("/(");
        res.append(nums[1]);
        for (int i = 2; i < n; i++) {
            res.append("/");
            res.append(nums[i]);
        }
        res.append(")");
        return res.toString();
    }



    public static void main(String[] args) {
        Y231203_First_1 y231203First1 = new Y231203_First_1();
        int [] nums = {2,3,4};
        System.out.println(y231203First1.optimalDivision(nums));
    }
}
