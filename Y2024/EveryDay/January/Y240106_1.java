package Y2024.EveryDay.January;

import java.util.Objects;

public class Y240106_1 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode firstNode = null, secondNode = null;
        firstNode = head;
        secondNode = firstNode.next;
        while (!Objects.isNull(secondNode)) {
            ListNode newNode = new ListNode(gcd(firstNode.val, secondNode.val));
            firstNode.next = newNode;
            newNode.next = secondNode;
            firstNode = secondNode;
            secondNode = secondNode.next;
        }
        return head;
    }

    public int find(int a, int b) {
        int tmp = a, result = 1;
        if (a > b) {
            a = b;
            b = tmp;
        }
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        return result;
    }

    /**
     * 欧几里得算法求最大公约数
     * @param a 第一个参数
     * @param b 第二个参数
     * @return 最大公约数
     */
    public int gcd(int a, int b) {
        while (b != 0) {
            int re = a % b;
            a = b;
            b = re;
        }
        return a;
    }

    public static void main(String[] args) {
        Y240106_1 y2401061 = new Y240106_1();
        ListNode head = new ListNode(18, new ListNode(6, new ListNode(10, new ListNode(3))));
        head = y2401061.insertGreatestCommonDivisors(head);
        while (!Objects.isNull(head)) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
