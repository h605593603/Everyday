package Y2023.Everyday;

import java.util.ArrayList;
import java.util.List;

public class Y231225_1 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result = new ArrayList<>();
        if (tomatoSlices%2 == 0) {
            int small = tomatoSlices/2;
            int big = small - cheeseSlices;
            if (big >= 0 && cheeseSlices - big >= 0) {
                result.add(big);
                result.add(cheeseSlices - big);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Y231225_1 y2312251 = new Y231225_1();
        int tomatoSlices = 0;
        int cheeseSlices = 0;
        System.out.println(y2312251.numOfBurgers(tomatoSlices, cheeseSlices));
    }
}
