package Y2023.Everyday;

public class Y231227_1 {
    public int isWinner(int[] player1, int[] player2) {
        int[] score = new int[] {0, 0};
        int first = 0, second = 0;

        for (int cur : player1) {
            if (10 == first || 10 == second) {
                score[0] += 2 * cur;
            } else {
                score[0] += cur;
            }
            first = second;
            second = cur;
        }
        first = 0;
        second = 0;
        for (int cur : player2) {
            if (10 == first || 10 == second) {
                score[1] += 2 * cur;
            } else {
                score[1] += cur;
            }
            first = second;
            second = cur;
        }
        if (score[0] > score[1]) {
            return 1;
        }
        if (score[0] < score[1]) {
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Y231227_1 y2312271 = new Y231227_1();
        int[] player1 = {4,10,7,9};
        int[] player2 = {6,5,2,3};
        System.out.println(y2312271.isWinner(player1, player2));
    }
}
