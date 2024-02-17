package Y2023.MoreOne;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Y20231212_First_1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (dq.isEmpty() || temperatures[i] <= temperatures[dq.peek()]) {
                dq.push(i);
            } else {
                while (!dq.isEmpty() && temperatures[i] > temperatures[dq.peek()]) {
                    result[dq.peek()] = i - dq.poll();
                }
                dq.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Y20231212_First_1 y20231212First1 = new Y20231212_First_1();
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};

        System.out.println(Arrays.toString(y20231212First1.dailyTemperatures(temperatures)));
    }
}
