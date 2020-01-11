package Question.TreeQuestion;

import Structures.Tree.TreeNode;

/*
 * 判断一棵树是否是对称的十分简单，只需要在遍历时既遍历左子树，又遍历右子树即可
 * */
public class SymmetricalBinaryTree {

    boolean isSymmetrical(TreeNode root){
        return helper(root, root);
    }

    private boolean helper(TreeNode l, TreeNode r){
        if (l == null)
            return r == null;
        if (r == null)
            return false;
        if (l.val != r.val)
            return false;
        return helper(l.left, r.right) && helper(l.right, r.left);
    }

}