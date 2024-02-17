package Y2023.Everyday;

import java.util.*;

public class Y231212_2 {
    public int[] secondGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<Integer>();
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[1] < nums[i]) {
                res[pq.poll()[0]] = nums[i];
            }
            if (stack.isEmpty() || nums[stack.peek()] >= nums[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    pq.add(new int[]{stack.peek(), nums[stack.poll()]});
                }
                stack.push(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Y231212_2 y2312122 = new Y231212_2();
        int[] nums = {2,4,0,9,6};
        System.out.println(Arrays.toString(y2312122.secondGreaterElement(nums)));
    }
}
