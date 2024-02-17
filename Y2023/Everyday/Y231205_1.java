package Y2023.Everyday;

import java.util.*;

public class Y231205_1 {
    public int[] havePeople;
    public int  peopleLimit;
    public long minimumFuelCost(int[][] roads, int seats) {
        /* 公共变量初始化 */
        havePeople = new int[roads.length + 1];
        Arrays.fill(havePeople, 1);
        this.peopleLimit = seats;
        /* 后继节点集 */
        Map<Integer, Set<Integer>> roadMap = new HashMap<>();

        for (int i = 0; i <= roads.length; i++) {
            roadMap.put(i, new HashSet<>());
        }

        for (int[] curRoad : roads) {
            Set<Integer> firstSet = roadMap.get(curRoad[0]);
            Set<Integer> secondSet = roadMap.get(curRoad[1]);

            firstSet.add(curRoad[1]);
            secondSet.add(curRoad[0]);
        }

        creatTree(roadMap, 0);

        long[] result = dfs(roadMap, 0, 0);

        return result[0];
    }

    private void creatTree(Map<Integer, Set<Integer>> roadMap, int cur) {
        if (roadMap.get(cur).isEmpty()) {
            return;
        }

        /* 清除对边 */
        for (int i : roadMap.get(cur)) {
            roadMap.get(i).remove(cur);
        }

        /* 遍历后继节点 */
        for (int i : roadMap.get(cur)) {
            creatTree(roadMap, i);
        }
    }

    private long[] dfs(Map<Integer, Set<Integer>> roadMap, int cur, int len) {
        if (roadMap.get(cur).isEmpty()) {
            havePeople[cur] =0;
            return new long[]{0, 1, 1};
        }
        long[] sumResult = new long[3];

        /* 遍历后继节点 */
        for (int i : roadMap.get(cur)) {
            long[] tmpResult = dfs(roadMap, i, len + 1);
            if (havePeople[cur] != 0 && peopleLimit*tmpResult[1] > tmpResult[2]) {
                havePeople[cur] = 0;
                tmpResult[2] ++;
            }
            /* 后继的距离之和 */
            sumResult[0] = sumResult[0] + tmpResult[0];
            sumResult[1] += tmpResult[1];
            sumResult[2] += tmpResult[2];
        }
        /* 子节点路径 */
        sumResult[0] += sumResult[1];
        /* 凑车 */
        if (peopleLimit > 1) {
            sumResult[1] = (int)sumResult[2]/peopleLimit + (sumResult[2]%peopleLimit == 0 ? 0 : 1);
        }

        /* 所有车都满员, 新发车 */
        if (havePeople[cur] != 0) {
            havePeople[cur] = 0;
            sumResult[1] ++;
            sumResult[2] ++;
        }
        return sumResult;
    }


    public static void main(String[] args) {
        Y231205_1 y2312051 = new Y231205_1();
        int[][] roads = {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
        System.out.println(y2312051.minimumFuelCost(roads, 2));
    }
}
