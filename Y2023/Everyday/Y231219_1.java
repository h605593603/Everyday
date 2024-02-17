package Y2023.Everyday;

import java.util.Arrays;

public class Y231219_1 {

    public int[] findPeakGrid(int[][] mat) {
        int[][] newMat = new int[mat.length + 2][mat[0].length + 2];
        for (int[] cow : newMat) {
            Arrays.fill(cow, -1);
        }
        for (int i = 1; i < mat.length + 1; i++) {
            int[] curCow = newMat[i];
            System.arraycopy(mat[i - 1], 0, curCow, 1, mat[i - 1].length);
        }
        for (int i = 1; i < newMat.length - 1; i++) {
            for (int j = 1; j < newMat[0].length - 1; j++) {
                if (newMat[i][j] > newMat[i + 1][j] && newMat[i][j] > newMat[i - 1][j] &&
                    newMat[i][j] > newMat[i][j + 1] && newMat[i][j] > newMat[i][j - 1]) {
                    return new int[]{i - 1, j - 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Y231219_1 y2312191 = new Y231219_1();
        int[][] mat = {{1,4}, {3,2}};
        System.out.println(Arrays.toString(y2312191.findPeakGrid(mat)));
    }
}
