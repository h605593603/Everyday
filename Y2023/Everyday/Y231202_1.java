package Y2023.Everyday;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Y231202_1 {
    public boolean carPooling(int[][] trips, int capacity) {
        int peopleNum = 0;
        PriorityQueue<int[]> priorityTo = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        Arrays.sort(trips, (a, b) -> a[1] - b [1]);
        for (int i =0; i < trips.length; i++) {
            while (!priorityTo.isEmpty() && priorityTo.peek()[1] <= trips[i][1]) {
                peopleNum = peopleNum - priorityTo.poll()[0];
            }
            /* 车未坐满, 上车 */
            if (peopleNum + trips[i][0] <= capacity) {
                priorityTo.add(new int[]{trips[i][0], trips[i][2]});
                peopleNum += trips[i][0];
            } else {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }


    public static void main(String[] args) {
        Y231202_1 y2312021 = new Y231202_1();
        int[][] trips = {{10,5,7}, {10,3,4}, {7,1,8}, {6,3,4}};
        int capacity = 24;
        System.out.println("" + y2312021.carPooling(trips, capacity));

    }
}
