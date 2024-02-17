package Y2024.EveryDay.January;

public class Y240104_1 {
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        int maxNum = (int) (Math.pow(2, n) - 1);
        int result = 0;

        for (int i = 0; i <= maxNum; i++) {
            if (numOne(i) == numSelect) {
                int matchNum = 0;
                for (int[] cur : matrix) {
                    int j = 0;
                    for (; j < n; j++) {
                        if (cur[j] == 1) {
                            int tmp = 1 << j;
                            if ((tmp & i) == 0) {
                                break;
                            }
                        }
                    }

                    if (j == n) {
                        matchNum++;
                    }
                }
                result = Math.max(result, matchNum);
            }
        }

        return result;
    }

    public int numOne(int cur) {
        int result = 0;
        for (int i = 1; i <= cur; i = i << 1) {
            if ((cur & i) != 0) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Y240104_1 y2401041 = new Y240104_1();
        int[][] matrix = {{0,0,0}, {1,0,1}, {0,1,1}, {0,0,1}};
        //int[][] matrix = {{1}, {0}};
        int numSelect = 2;
        System.out.println(y2401041.maximumRows(matrix, numSelect));
    }
}
