package Y2023.Everyday;

import java.util.Arrays;
import java.util.List;

public class Y231221_2 {
/**
 * 不对
 */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        int[][] lostSet = new int[n][2];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int cur = maxHeights.get(i);
            sum += cur;
            lostSet[i] = new int[] {0, cur};
            for (int j = i; j >= 0; j--) {
                lostSet[j][0] += Math.max(lostSet[j][1] - cur, 0);
                lostSet[j][1] = Math.min(lostSet[j][1], cur);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, sum - lostSet[i][0]);
        }
        return result;
    }

    public static void main(String[] args) {
        Y231221_1 y2312211 = new Y231221_1();
        Integer[] maxHeights = {5,3,4,1,1};
        System.out.println(y2312211.maximumSumOfHeights(Arrays.asList(maxHeights)));
    }
}
