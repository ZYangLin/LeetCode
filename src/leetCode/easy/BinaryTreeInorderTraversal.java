package leetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();

        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode( 2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);

        btit.inorderTraversal(node1);


    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doHelp(root, res);
        return res;
    }

    private void doHelp(TreeNode root, List<Integer> res){
        if (root != null) {
            doHelp(root.left, res);
            res.add(root.val);
            doHelp(root.right, res);
        }
    }
}
