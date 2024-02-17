package Y2023.Everyday;

public class Y231229_1 {
    public int buyChoco(int[] prices, int money) {
        /* 巧克力不够处理 */
        if (prices.length < 2) {
            return money;
        }

        int first = Math.min(prices[0], prices[1]);
        int second = Math.max(prices[0], prices[1]);

        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < first) {
                second = first;
                first = prices[i];
            } else if (prices[i] < second) {
                second = prices[i];
            }
        }

        return (money - first - second) >= 0 ? money - first - second : money;
    }

    public static void main(String[] args) {
        Y231229_1 y2312291 = new Y231229_1();

        int[] prices = {1,2,3};
        int money = 3;
        System.out.println(y2312291.buyChoco(prices, money));
    }
}
