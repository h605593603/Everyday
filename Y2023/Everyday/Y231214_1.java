package Y2023.Everyday;

import java.util.Arrays;

public class Y231214_1 {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int minWidth = grid[0].length, minHeight = grid.length;

        int[][] newGrid = new int[grid.length + 1][grid[0].length + 1];
        Arrays.fill(newGrid[grid.length], 1);
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, newGrid[i], 0, grid[0].length);
            newGrid[i][grid[0].length] = 1;
        }

        grid = newGrid;

        for (int[] cur : grid) {
            int weight = -1;
            for (int i = 0; i < cur.length; i++) {
                if (cur[i] != 0) {
                    /* 遇到第一堵墙 */
                    if (i - weight > 1) {
                        minWidth = Math.min(minWidth, i - weight - 1);
                    }
                    weight = i;
                }
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            int height = -1;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] != 0) {
                    if (j - height > 1) {
                        minHeight = Math.min(minHeight, j - height - 1);
                    }
                    height = j;
                }
            }
        }

        if (minWidth >= stampWidth && minHeight >= stampHeight) {
            return Boolean.TRUE;
        }
        if (grid[0][0] == 1 && minWidth == grid[0].length - 1 && minHeight == grid.length - 1) {
            return Boolean.TRUE;
        }
        return  Boolean.FALSE;
    }

    public static void main(String[] args) {
        Y231214_1 y2312141 = new Y231214_1();
        int[][] grid = {{0,0,0,0,0},
                        {0,0,0,0,0},
                        {0,0,1,0,0},
                        {0,0,0,0,1},
                        {0,0,0,1,1}};
        int stampHeight = 9;
        int stampWidth = 4;
        System.out.println(y2312141.possibleToStamp(grid, stampHeight,stampWidth));
    }
}

