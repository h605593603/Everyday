package Y2024.EveryDay.January;

import java.util.Objects;

public class Y240114_1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        while (!Objects.isNull(second)) {
            if (first.val == second.val) {
                first.next = second.next;
                second = second.next;
            } else {
                first = second;
                second = second.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Y240114_1 y2401141 = new Y240114_1();
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        head = y2401141.deleteDuplicates(head);
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
