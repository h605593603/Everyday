package Y2024.EveryDay.January;

import java.util.ArrayList;
import java.util.List;

public class Y240127_1 {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int left = 1, right = 200000000, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean valid = false;
            for (int i = 0; i < k; ++i) {
                long spend = 0;
                for (int j = 0; j < n; ++j) {
                    spend += Math.max((long) composition.get(i).get(j) * mid - stock.get(j), 0) * cost.get(j);
                }
                if (spend <= budget) {
                    valid = true;
                    break;
                }
            }
            if (valid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Y240127_1 y2401271 = new Y240127_1();
        int n = 0;
        int k = 0;
        int budget = 0;
        List<List<Integer>> composition = new ArrayList<>();
        List<Integer> stock = new ArrayList<>();
        List<Integer> cost = new ArrayList<>();

        System.out.println(y2401271.maxNumberOfAlloys(n, k, budget, composition, stock, cost));
    }
}
