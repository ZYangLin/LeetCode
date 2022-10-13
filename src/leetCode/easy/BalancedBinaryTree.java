package leetCode.easy;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return -1;

        int l = getDepth(root.left);
//        if (l )

        return 0;
    }


}

