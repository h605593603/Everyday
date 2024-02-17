package Y2023.WeeklyCompetition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Y231210_third {
    public long countSubarrays(int[] nums, int k) {
        long result = 0;
        List<Integer> masPos = new ArrayList();
        masPos.add(-1);
        int max = Arrays.stream(nums).max().getAsInt();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                masPos.add(i);
            }
        }
        masPos.add(nums.length);
        if (masPos.size() - 2 < k) {
            return 0;
        } else {
            for (int i = 1; i + k < masPos.size(); i++) {
                long curNum = (long) (masPos.get(i) - masPos.get(i - 1)) *(masPos.get(masPos.size() - 1) - masPos.get(i + k - 1));
                result += curNum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Y231210_third y231210Third = new Y231210_third();
        int [] variables = {1,3,2,3,3,1,1,2,3,1,2,1};
        int target = 2;
        System.out.println(y231210Third.countSubarrays(variables, target));
    }
}
