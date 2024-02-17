package Y2023.WeeklyCompetition;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Y231210_second {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] cur = variables[i];
            BigDecimal tgt = BigDecimal.valueOf(target);
            if (tgt.equals(BigDecimal.valueOf(cur[0]).pow(cur[1]).divideAndRemainder(BigDecimal.valueOf(10))[1].pow(cur[2]).divideAndRemainder(BigDecimal.valueOf(cur[3]))[1])) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Y231210_first y231210First = new Y231210_first();
        int [][] variables = {{51,35,21,52}, {31,12,21,24}, {53,38,9,33}};
        int target = 1;
        System.out.println(y231210First.getGoodIndices(variables, target));
    }
}
