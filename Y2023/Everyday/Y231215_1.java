package Y2023.Everyday;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Y231215_1 {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public TreeNode reverseOddLevels(TreeNode root) {
        int levels = 0;
        Deque<TreeNode> bfsSet = new ArrayDeque<>();
        bfsSet.add(root);
        while (!bfsSet.isEmpty()) {
            if (levels % 2 == 0) {
                for (int i = 0; i < Math.pow(2, levels); i++) {
                    TreeNode curTreeNode = bfsSet.pop();
                    if (!Objects.isNull(curTreeNode.left)) {
                        bfsSet.add(curTreeNode.left);
                        bfsSet.add(curTreeNode.right);
                    }
                }
            } else {
                Deque<TreeNode> tmpSet = new ArrayDeque<>();
                /* 取出本层 */
                for (int i = 0; i < Math.pow(2, levels - 1); i++) {
                    TreeNode leftTreeNode = bfsSet.pop();
                    TreeNode rightTreeNode = bfsSet.pop();
                    tmpSet.add(leftTreeNode);
                    tmpSet.add(rightTreeNode);
                    if (!Objects.isNull(rightTreeNode.left)) {
                        bfsSet.add(leftTreeNode.left);
                        bfsSet.add(leftTreeNode.right);
                        bfsSet.add(rightTreeNode.left);
                        bfsSet.add(rightTreeNode.right);
                    }
                }
                /* 反转 */
                while (!tmpSet.isEmpty()) {
                    TreeNode firstTreeNode = tmpSet.removeFirst();
                    TreeNode lastTreeNode = tmpSet.removeLast();
                    int firstVal = firstTreeNode.val;
                    firstTreeNode.val = lastTreeNode.val;
                    lastTreeNode.val = firstVal;
                }
            }
            levels++;
        }
        return root;
    }


    public static void main(String[] args) {
        Y231215_1 y2312151 = new Y231215_1();
        TreeNode root = new TreeNode(2,
          new TreeNode(3, new TreeNode(8, null, null), new TreeNode(13, null, null)),
          new TreeNode(5, new TreeNode(21, null, null), new TreeNode(34, null, null)));
        System.out.println(y2312151.reverseOddLevels(root).toString());

    }
}
