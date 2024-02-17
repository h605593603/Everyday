package Y2024.EveryDay.January;

import java.util.HashMap;
import java.util.Map;

public class Y240108_1 {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        double[][] lenPoints = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    lenPoints[i][j] = -1;
                } else {
                    lenPoints[i][j] = Math.pow(points[i][0] - points[j][0], 2)
                            + Math.pow(points[i][1] - points[j][1], 2);
                }
            }
        }
        int result = 0;
        for (int i = 0; i <n; i++) {
            Map<Double, Integer> numMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    numMap.put(lenPoints[i][j], numMap.getOrDefault(lenPoints[i][j], 0) + 1);
                }
            }
            for (Map.Entry<Double, Integer> entry : numMap.entrySet()) {
                if (entry.getValue() >= 2) {
                    result += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Y240108_1 y2401081 = new Y240108_1();
        int[][] points = {{1,1}};
        System.out.println(y2401081.numberOfBoomerangs(points));
    }
}
