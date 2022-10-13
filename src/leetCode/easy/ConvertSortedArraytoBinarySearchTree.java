package leetCode.easy;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length -1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int l, int r) {
        if (l > r) return null;

        int m = (l + r) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = sortedArrayToBSTHelper(nums, l, m -1);
        root.right = sortedArrayToBSTHelper(nums, m + 1, r);
        return root;
    }
}
