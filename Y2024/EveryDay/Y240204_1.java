package Y2024.EveryDay;

public class Y240204_1 {
    public boolean canWinNim(int n) {
        int left = n % 3;
        int m = n / 3;

        if (n <= 3) {
            return true;
        }

        return 0 == getStone(n, 0);
    }

    private int getStone(int left, int cur) {
        if (left <= 3) {
            return cur;
        }
        int next = 0;
        if (cur == 0) {
             next = 1;
        }

        if (cur != getStone(left - 1, next)) {
            if (cur != getStone(left - 2, next)) {
                if (cur !=  getStone(left - 3, next)) {
                    return next;
                }
            }
        }

        return cur;
    }


    public static void main(String[] args) {
        Y240204_1 y2402041 = new Y240204_1();
        int n = 42;

        System.out.println(y2402041.canWinNim(n));
    }
}
