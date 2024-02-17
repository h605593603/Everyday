package Y2024.EveryDay;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Y240206_1 {
    public int magicTower(int[] nums) {
        PriorityQueue<Integer> minScore = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        int result = 0;
        long flood = 1;
        long leftNums = 0;

        for (int i = 0; i < nums.length; i++) {
            minScore.add(nums[i]);
            flood += nums[i];
            if (flood <= 0) {
                int tmp = minScore.poll();
                leftNums += tmp;
                flood -= tmp;
                result++;
            }
        }
        return flood + leftNums > 0 ? result : -1;
    }

    public static void main(String[] args) {
        Y240206_1 y2402061 = new Y240206_1();
        int[] nums = new int[]{100,100,100,-250,-60,-140,-50,-50,100,150};

        System.out.println(y2402061.magicTower(nums));
    }
}
