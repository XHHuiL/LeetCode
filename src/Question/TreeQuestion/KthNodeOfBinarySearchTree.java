package Question.TreeQuestion;

import Structures.Tree.TreeNode;

import java.util.ArrayList;

public class KthNodeOfBinarySearchTree {

    /*
     * 对二叉搜索树进行一次中序遍历之后，便得到一个排序好的数组，然后直接获取到第k个元素即可
     * */
    TreeNode kthNode(TreeNode root, int k) {
        if (root == null)
            return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        infixTraverse(root, list);
        if (list.size() < k || k == 0)
            return null;
        return list.get(k-1);
    }

    private void infixTraverse(TreeNode root, ArrayList<TreeNode> list) {
        if (root.left != null)
            infixTraverse(root.left, list);
        list.add(root);
        if (root.right != null)
            infixTraverse(root.right, list);
    }

}