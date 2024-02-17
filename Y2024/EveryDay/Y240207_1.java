package Y2024.EveryDay;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Y240207_1 {
    public TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer, Integer> highMap = new HashMap<>();

        root.val = 0;
        this.sumHighValue(root, 1, highMap);

        this.setNewValue(root, 1, highMap);

        return root;
    }

    /**
     * 计算每层最大值
     * @param root
     * @param high
     * @param highMap
     */
    private void sumHighValue(TreeNode root, int high, Map<Integer, Integer> highMap) {
        /* 左节点 */
        if (!Objects.isNull(root.left)) {
            highMap.put(high, highMap.getOrDefault(high, 0) + root.left.val);
            sumHighValue(root.left, high + 1, highMap);
        }

        /* 右节点 */
        if (!Objects.isNull(root.right)) {
            highMap.put(high, highMap.getOrDefault(high, 0) + root.right.val);
            sumHighValue(root.right, high + 1, highMap);
        }
    }

    /**
     * 设置每层新值
     * @param root
     * @param high
     * @param highMap
     */
    private void setNewValue(TreeNode root, int high, Map<Integer, Integer> highMap) {
        int curSum = 0;
        /* 左节点 */
        if (!Objects.isNull(root.left)) {
            curSum += root.left.val;
        }

        /* 右节点 */
        if (!Objects.isNull(root.right)) {
            curSum += root.right.val;
        }

        /* 左节点 */
        if (!Objects.isNull(root.left)) {
            root.left.val = highMap.get(high) - curSum;
            setNewValue(root.left, high + 1, highMap);
        }

        /* 右节点 */
        if (!Objects.isNull(root.right)) {
            root.right.val = highMap.get(high) - curSum;
            setNewValue(root.right, high + 1, highMap);
        }
    }

    public static void main(String[] args) {
        Y240207_1 y2402071 = new Y240207_1();
    }

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
}
