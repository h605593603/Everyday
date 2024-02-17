package Y2023.Everyday;

import java.util.Arrays;

public class Y231209_1 {
    public int nextBeautifulNumber(int n) {
        n = n + 1;
        while (!checkBeautifuleNumber(n)) {
            n++;
        }

        return n;
    }
    public boolean checkBeautifuleNumber(int n) {
        int[] number = new int[10];
        Arrays.fill(number, 0);
        for (int i = n; i > 0;  i = i/10) {
            int tmp = i%10;
            number[tmp] ++;
        }
        for (int i = 0; i < 10; i++) {
            if (number[i] != 0 && number[i] != i) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        Y231209_1 y2312091 = new Y231209_1();
        int n = 1;
        System.out.println(y2312091.nextBeautifulNumber(n));
    }
}
