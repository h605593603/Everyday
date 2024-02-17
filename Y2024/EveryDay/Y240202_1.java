package Y2024.EveryDay;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Y240202_1 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        List<Integer>  valueDiff = new ArrayList<>();

        for (int i = 0; i < aliceValues.length; i++) {
            valueDiff.add(i);
        }
        valueDiff.sort(Comparator.comparingInt(a -> aliceValues[a] - bobValues[a]));

        int valuesAlice = 0, valuesBob = 0;
        for (int i = 0; i < aliceValues.length; i++) {
            /* Alice回合 */
            if (i % 2 == 0) {
                valuesAlice = getValues(aliceValues, bobValues, valueDiff, valuesAlice);
            } else {
                /* bobValues回合 */
                valuesBob = getValues(aliceValues, bobValues, valueDiff, valuesBob);
            }
        }
        return Integer.compare(valuesAlice, valuesBob);
    }

    private int getValues(int[] aliceValues, int[] bobValues, List<Integer> valueDiff, int valuesAlice) {
        int left = valueDiff.get(0);
        int right = valueDiff.get(valueDiff.size() - 1);

        int diffLeft = aliceValues[left] - bobValues[left];
        int diffRight = -aliceValues[right] + bobValues[right];

        if (diffLeft >= diffRight) {
            valuesAlice += aliceValues[left];
            valueDiff.remove(left);
        } else {
            valuesAlice += aliceValues[right];
            valueDiff.remove(right);
        }
        return valuesAlice;
    }

    public static void main(String[] args) {
        Y240202_1 y2402021 = new Y240202_1();
        int[] aliceValues = {1, 3};
        int[] bobValues = {2, 1};
        System.out.println(y2402021.stoneGameVI(aliceValues, bobValues));
    }
}
