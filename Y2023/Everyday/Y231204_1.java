package Y2023.Everyday;

public class Y231204_1 {
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

    int sum = 0;
    int lastVal = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);

        dfsSum(root);
        return root;
    }

    void dfs(TreeNode root) {

        if (null == root.left && null == root.right) {
            sum += root.val;
            return;
        }
        if (null != root.left) {
            dfs(root.left);
        }
        sum += root.val;
        if (null != root.right) {
            dfs(root.right);
        }
    }

    void dfsSum(TreeNode root) {
        if (null == root.left && null == root.right) {
            int tmp = root.val;
            root.val = sum - lastVal;
            sum = sum - lastVal;
            lastVal = tmp;
            return;
        }
        if (null != root.left) {
            dfsSum(root.left);
        }
        int temp = root.val;
        root.val = sum - lastVal;
        sum = sum - lastVal;
        lastVal = temp;

        if (null != root.right) {
            dfsSum(root.right);
        }
    }


    public static void main(String[] args) {
        Y231204_1 y2312041 = new Y231204_1();
        TreeNode root = new TreeNode(2), left = new TreeNode(1), right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode result = y2312041.bstToGst(root);

    }
}


