package Y2023.Everyday;

public class Y231203_1 {
    public int maxScore(int[] cardPoints, int k) {
        int left = 0, right = cardPoints.length - 1;
        int len = cardPoints.length;
        return findMax(cardPoints, -1, len, 0, k);
    }

    public int findMax(int[] cardPoints, int left, int right, int sum, int k) {
        int len = cardPoints.length;
        if (left == right  || (left + 1) + (len - right) >= k) {
            return sum;
        }
        /* 左指针移动 */
        int leftSum = sum + cardPoints[left + 1];
        leftSum = findMax(cardPoints, left + 1, right, leftSum, k);
        /* 右指针移动 */
        int rightSum = sum + cardPoints[right - 1];
        rightSum = findMax(cardPoints, left, right - 1, rightSum, k);
        sum = Math.max(leftSum, rightSum);
        return sum;
    }

    public static void main(String[] args) {
        Y231203_1 y2312031 = new Y231203_1();
        int[] cardPoints = {53,14,91,35,51,9,80,27,6,15,77,86,34,62,55,45,91,45,23,75,66,42,62,13,34,18,89,67,93,83,100};
        int k = 31;
        System.out.println(y2312031.maxScore(cardPoints, k));
    }
}
