package Y2024.EveryDay.January;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Y240105_1 {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[heights.length];
        Arrays.fill(result, 0);
        for (int i = heights.length - 1; i >= 0; i--) {
            Deque<Integer> tmp = new ArrayDeque<>();
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                tmp.push(stack.pop());
            }
            if (stack.isEmpty() && tmp.isEmpty()) {
                result[i] = 0;
            } else if(stack.isEmpty()) {
                result[i] = tmp.size();
            } else {
                result[i] = tmp.size() + 1;
            }
            while (!tmp.isEmpty()) {
                stack.push(tmp.pop());
            }
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.poll();
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Y240105_1 y2401051 = new Y240105_1();
        int[] heights = {10,6,8,5,11,9};
        System.out.println(Arrays.toString(y2401051.canSeePersonsCount(heights)));
    }
}
