package Y2023.Everyday;

public class Y231203_2 {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int result = 0;
        int temResult = 0;

        /* 全取左边 */
        for (int i = 0; i < k; i++) {
            temResult += cardPoints[i];
        }
        result = temResult;

        /* 左边减少个数 */
        for (int i = 1; i <= k; i++) {
            temResult = temResult - cardPoints[k - i] + cardPoints[len - i];
            result = Math.max(temResult, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Y231203_1 y2312031 = new Y231203_1();
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k =3;
        System.out.println(y2312031.maxScore(cardPoints, k));
    }
}
