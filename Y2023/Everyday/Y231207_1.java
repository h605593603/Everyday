package Y2023.Everyday;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Y231207_1 {
    int changeNum = 0;
    public int minReorder(int n, int[][] connections) {
        List<Set<Integer>> edgeSet = new ArrayList<>();
        List<Set<Integer>> edgeSetLim = new ArrayList<>();
        /* 初始化边集 */
        for (int i = 0; i < n; i++) {
            edgeSet.add(new HashSet<>());
            edgeSetLim.add(new HashSet<>());
        }
        /* 构造边集 */
        for (int[] edge : connections) {
            edgeSet.get(edge[0]).add(edge[1]);
            edgeSet.get(edge[1]).add(edge[0]);
            edgeSetLim.get(edge[0]).add(edge[1]);
        }
        dfs(0, -1, edgeSet, edgeSetLim);
        return changeNum;

    }

    private void dfs(int cur, int last, List<Set<Integer>> edgeSet, List<Set<Integer>> edgeSetLim) {
        for (int num : edgeSet.get(cur)) {
            if (last != num) {
                if (!edgeSetLim.get(num).contains(cur)) {
                    this.changeNum++;
                }
                dfs(num, cur, edgeSet, edgeSetLim);
            }
        }
    }

    public static void main(String[] args) {
        Y231207_1 y2312071 = new Y231207_1();

        int n = 6;
        int[][] connections = {{0,1}, {1,3}, {2,3}, {4,0}, {4,5}};
        System.out.println(y2312071.minReorder(n, connections));
    }
}
