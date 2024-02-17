package Y2024.WeeklyCompetition;

public class Y240107_first {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxC = 0;
        int maxPos = 0;

        for (int i = 0; i < dimensions.length; i++) {
            int[] cur = dimensions[i];
            double tmpC = Math.pow(cur[0], 2) + Math.pow(cur[1], 2);
            if (tmpC > maxC) {
                maxC = tmpC;
                maxPos = i;
            } else if (tmpC == maxC) {
                if (cur[0]*cur[1] > dimensions[maxPos][0]*dimensions[maxPos][1]) {
                    maxC = tmpC;
                    maxPos = i;
                }
            }
        }
        return dimensions[maxPos][0]*dimensions[maxPos][1];
    }

    public static void main(String[] args) {
        Y240107_first y240107First = new Y240107_first();
        int[][] dimensions = {{9,3},{8,6}};
        System.out.println(y240107First.areaOfMaxDiagonal(dimensions));
    }
}
