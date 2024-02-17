package Y2023.Everyday;

import java.util.*;

public class Y231221_1 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long result = 0;


        for (int i = 0; i < maxHeights.size(); i++) {
            int maxHe = maxHeights.get(i);
            long tmpSum = 0;
            tmpSum += maxHe;
            long tmpMh = maxHe;
            for (int j = i - 1; j >= 0; j--) {
                tmpSum += Math.min(tmpMh, maxHeights.get(j));
                tmpMh = Math.min(tmpMh, maxHeights.get(j));
            }
            tmpMh = maxHe;
            for (int j = i + 1; j < maxHeights.size(); j++) {
                tmpSum += Math.min(tmpMh, maxHeights.get(j));
                tmpMh = Math.min(tmpMh, maxHeights.get(j));
            }
            result = Math.max(result, tmpSum);

        }
        return result;
    }

    public static void main(String[] args) {
        Y231221_1 y2312211 = new Y231221_1();
        Integer[] maxHeights = {6,5,2,1,5,4,4,2};
        System.out.println(y2312211.maximumSumOfHeights(Arrays.asList(maxHeights)));
    }
}
