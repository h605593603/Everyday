package Y2023.Everyday;

import java.util.ArrayList;
import java.util.List;

public class Y231205_2 {
    long res = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<Integer>();
        }
        for (int[] e : roads) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        dfs(0, -1, seats, g);
        return res;
    }

    public int dfs(int cur, int fa, int seats, List<Integer>[] g) {
        int peopleSum = 1;
        for (int ne : g[cur]) {
            if (ne != fa) {
                int peopleCnt = dfs(ne, cur, seats, g);
                peopleSum += peopleCnt;
                res += (peopleCnt + seats - 1) / seats;
            }
        }
        return peopleSum;
    }

    public static void main(String[] args) {
        Y231205_2 y2312051 = new Y231205_2();
        int[][] roads = {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
        System.out.println(y2312051.minimumFuelCost(roads, 2));
    }
}
