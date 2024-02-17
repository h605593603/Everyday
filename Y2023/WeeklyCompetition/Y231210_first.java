package Y2023.WeeklyCompetition;

import java.util.ArrayList;
import java.util.List;

public class Y231210_first {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] cur = variables[i];
            if (target == Math.pow(Math.pow(cur[0], cur[1]), cur[2]) % cur[3]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Y231210_first y231210First = new Y231210_first();
        int [][] variables = {{2,2,3,2},{1,3,3,2},{3,2,2,3},{3,1,2,3},{1,2,3,1},{2,2,2,2},{2,1,3,1},{3,2,2,2},{2,1,3,1},{3,3,1,3}};
        int target = 0;
        System.out.println(y231210First.getGoodIndices(variables, target));
    }
}
