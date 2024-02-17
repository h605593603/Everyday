package Y2024.EveryDay.January;

import java.util.Objects;

public class Y240115_1 {
    public ListNode deleteDuplicates(ListNode head) {
        head = dfsDeleteDuplicates(head, 101);
        return head;
    }

    public ListNode dfsDeleteDuplicates(ListNode curNode, int lastval) {
        if (Objects.isNull(curNode)) {
            return curNode;
        }
        int oriNextInt = 101;
        if (!Objects.isNull(curNode.next)) {
            oriNextInt = curNode.next.val;
        }
        curNode.next = dfsDeleteDuplicates(curNode.next, curNode.val);
        if (curNode.val == lastval || curNode.val == oriNextInt) {
            return curNode.next;
        }
        return curNode;
    }

    public static void main(String[] args) {
        Y240115_1 y2401151 = new Y240115_1();
        Y240115_1.ListNode head = new Y240115_1.ListNode(1, new Y240115_1.ListNode(1, new Y240115_1.ListNode(2, new Y240115_1.ListNode(3, new Y240115_1.ListNode(3)))));
        head = y2401151.deleteDuplicates(head);
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
        ListNode(int val, Y240115_1.ListNode next) { this.val = val; this.next = next; }
    }
}
