package Y2024.EveryDay.January;

import java.util.*;

public class Y240122_1 {
    public int maximumSwap(int num) {
        List<Character> numList = new ArrayList<>();
        int cur = num;
        while (cur > 0) {
            int tmp = cur%10;
            cur = cur/10;
            numList.add((char) (tmp + '0'));
        }
        Collections.sort(numList);
        Collections.reverse(numList);

        char[] str = String.valueOf(num).toCharArray();
        for (int left = 0; left < str.length; left++) {
            if (str[left] != numList.get(left)) {
                char curNum = str[left];
                str[left] = numList.get(left);
                for (int right = str.length - 1; right > left; right--) {
                    if (numList.get(left) == str[right]) {
                        str[right] = curNum;
                        return Integer.parseInt(new String(str));
                    }
                }
            }
        }
        return num;
    }


    public static void main(String[] args) {
        Y240122_1 y2401221 = new Y240122_1();
        int num = 2736;
        System.out.println(y2401221.maximumSwap(num));
    }
}
