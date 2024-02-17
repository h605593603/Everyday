package Y2024.WeeklyCompetition;

/**
 * 没做出来
 */
public class Y240107_second {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        /* 车同行且不阻挡 */
        if (a == c && (a != e || (f < Math.min(b, d) || f > Math.max(b, d)))) {
            return 1;
        }

        /* 车同列且不阻挡 */
        if (b == d && (b != f || (e < Math.min(a, c) || e > Math.max(a, c)))) {
            return 1;
        }

        /* 象同斜线且不阻挡 */
        if (Math.abs(e - c) == Math.abs(f - d)) {
            int h = e - c > 0 ? -1 : 1;
            int l = f - d > 0 ? -1 : 1;
            while (b != e) {
                e += h;
                f += l;
                if (e == a && f == b) {
                    return 2;
                }
            }
            return 1;
        }

        return 2;
    }

    public static void main(String[] args) {
        Y240107_second y240107Second = new Y240107_second();
        int a = 1;
        int b = 1;
        int c = 1;
        int d = 4;
        int e = 1;
        int f = 8;
        System.out.println(y240107Second.minMovesToCaptureTheQueen(a, b, c, d, e, f));
    }
}
