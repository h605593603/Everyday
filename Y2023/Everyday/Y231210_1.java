package Y2023.Everyday;

public class Y231210_1 {
    public int climbStairs(int n) {
        int firstSum = 2, secondSum = 1;
        int result = 0;

        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 2;
        }

        for (int i = 2; i < n; i++) {
            result = firstSum + secondSum;
            secondSum = firstSum;
            firstSum = result;
        }

        return result;
    }

    public static void main(String[] args) {
        Y231210_1 y2312101 = new Y231210_1();
        int n = 5;
        System.out.println(y2312101.climbStairs(n));
    }
}
