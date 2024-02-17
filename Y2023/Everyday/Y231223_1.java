package Y2023.Everyday;

import java.util.PriorityQueue;

public class Y231223_1 {
    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        int sum = 0;
        PriorityQueue<int[]> maxLost = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for (int i = 0; i < n; i++) {
            int lost = (int)(piles[i]/2);
            sum += piles[i];
            maxLost.add(new int[]{lost, i});
        }

        for (int i = 0; i < k; i++) {
            int[] cur = maxLost.poll();
            piles[cur[1]] -= cur[0];
            int newLost = (int)(piles[cur[1]]/2);
            maxLost.add(new int[]{newLost, cur[1]});
            sum -= cur[0];
        }

        return sum;
    }

    public static void main(String[] args) {
        Y231223_1 y2312231 = new Y231223_1();
        int[] piles = {10000};
        int k = 10000;
        System.out.println(y2312231.minStoneSum(piles, k));
    }
}
