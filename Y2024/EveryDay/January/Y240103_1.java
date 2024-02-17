package Y2024.EveryDay.January;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Y240103_1 {
    public ListNode removeNodes(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> arr = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            arr.add(cur.val);
        }

        for (int i = 0; i < arr.size(); i++) {
            while (!stack.isEmpty() && arr.get(i) > arr.get(stack.peek())) {
                stack.poll();
            }

            stack.push(i);
        }
        ListNode result = new ListNode(arr.get(stack.removeLast()));
        ListNode cur = result;
        while (!stack.isEmpty()) {
            cur.next = new ListNode(arr.get(stack.removeLast()));
            cur = cur.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Y240103_1 y2401031 = new Y240103_1();
        ListNode head = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));
        ListNode cur = y2401031.removeNodes(head);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
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
