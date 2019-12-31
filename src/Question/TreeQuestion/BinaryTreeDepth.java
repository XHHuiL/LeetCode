package Question.TreeQuestion;

import Structures.Tree.TreeNode;

public class BinaryTreeDepth {

    public int depth(TreeNode root){
        if (root == null)
            return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        // attention: 当前树的深度为左右子树深度较大值+1
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

}