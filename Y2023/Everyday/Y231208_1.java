package Y2023.Everyday;

import java.util.Arrays;
import java.util.Comparator;

public class Y231208_1 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        /* 记录以n为终点最高收入 */
        long[] dp = new long[n];
        dp[0] = 0;
        Arrays.sort(rides, Comparator.comparingInt(a -> a[1]));
        int ridesNum = 0;
        for (int i = 1; i < n; i++) {
            long temMoney = dp[i - 1];
            while (ridesNum < rides.length && rides[ridesNum][1] <= i + 1) {
                long curMoney = rides[ridesNum][2] + rides[ridesNum][1] - rides[ridesNum][0] + dp[rides[ridesNum][0] - 1];
                temMoney = Math.max(temMoney, curMoney);
                ridesNum++;
            }

            dp[i] = Math.max(dp[i - 1], temMoney);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Y231208_1 y2312081 = new Y231208_1();
        int n = 5;
        int[][] rides = {{2,3,4}, {4,5,1}};
        System.out.println(y2312081.maxTaxiEarnings(n, rides));
    }
}
