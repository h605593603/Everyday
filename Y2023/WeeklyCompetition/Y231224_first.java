package Y2023.WeeklyCompetition;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Y231224_first {
    public int[] numberGame(int[] nums) {
        int[] result = new int[nums.length];
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        for (int cur : nums) {
            minQueue.add(cur);
        }

        for (int i = 0; i < nums.length/2; i++) {
            int first = minQueue.poll();
            int second = minQueue.poll();
            result[2*i] = second;
            result[2*i + 1] = first;
        }
        return result;
    }

    public static void main(String[] args) {
        Y231224_first y231224First = new Y231224_first();
        int[] nums = {5,4,2,3};
        System.out.println(Arrays.toString(y231224First.numberGame(nums)));
    }
}
