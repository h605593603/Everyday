package Y2023.Everyday;

import java.util.*;

public class Y231201_2 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, List<Integer>> numPosition = new HashMap<>();
        List<HashSet<Integer>> rankSet = new ArrayList<>();
        List<HashSet<Integer>> rowSet = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            rankSet.add(new HashSet<Integer>());
            for (int j = 0; j < mat[0].length; j++) {
                List<Integer> pos = new ArrayList<>();
                pos.add(i);
                pos.add(j);
                numPosition.put(mat[i][j], pos);
                if (rowSet.size() <= j) {
                    rowSet.add(new HashSet<Integer>());
                }
                Set<Integer> tmp = rowSet.get(j);
                tmp.add(mat[i][j]);
                tmp = rankSet.get(i);
                tmp.add(mat[i][j]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            List<Integer> pos = numPosition.get(arr[i]);
            rankSet.get(pos.get(0)).remove(mat[pos.get(0)][pos.get(1)]);
            rowSet.get(pos.get(1)).remove(mat[pos.get(0)][pos.get(1)]);

            if (rankSet.get(pos.get(0)).isEmpty() || rowSet.get(pos.get(1)).isEmpty()) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Y231201_2 y231201 = new Y231201_2();
        int[] arr = {6,2,3,1,4,5};
        int[][]  mat = {{3,2,5}, {1,4,6},{8,7,9}};
        System.out.println(y231201.firstCompleteIndex(arr, mat));
    }
}
