package Y2023.Everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Y231201 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, List<Integer>> numPosition = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                List<Integer> pos = new ArrayList<>();
                pos.add(i);
                pos.add(j);
                numPosition.put(mat[i][j], pos);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            List<Integer> pos = numPosition.get(arr[i]);
            mat[pos.get(0)][pos.get(1)] = 0;
            if (check(mat, pos.get(0), pos.get(1))) {
                return i;
            }
        }
        return 0;
    }

    Boolean check(int[][] mat, int x, int y) {
        Boolean result = Boolean.TRUE;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][y] != 0) {
                result =  Boolean.FALSE;
            }
        }
        if (result) {
            return result;
        } else {
            result = Boolean.TRUE;
        }

        for (int i = 0; i < mat[0].length; i++) {
            if (mat[x][i] != 0) {
                result =  Boolean.FALSE;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Y231201 y231201 = new Y231201();
        int[] arr = {6,2,3,1,4,5};
        int[][]  mat = {{3,2,5}, {1,4,6},{8,7,9}};
        System.out.println(y231201.firstCompleteIndex(arr, mat));
    }
}
