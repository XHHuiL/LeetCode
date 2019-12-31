package Question.TreeQuestion;

import Structures.Tree.TreeNode;

public class IsBalanced {

    /*
     * 判断一棵二叉树是否是平衡的二叉树（任意节点的左右子树高度查不能超过1）
     * 由于需要返回两个值：是否平衡、树的高度
     * 不能使用Integer，因为Integer内部的value属性由final修饰，所以需要自己定义一个简单的封装类型或者使用数组
     * */
    private class MyInteger{
        int value;
    }

    public boolean isBalanced(TreeNode root) {
        MyInteger depth = new MyInteger();
        return helper(root, depth);
    }

    /*
    * 使用后序遍历，避免重复扫描树中的部分节点，减小时间复杂度
    * */
    private boolean helper(TreeNode root, MyInteger depth) {
        if (root == null) {
            depth.value = 0;
            return true;
        }
        // step 1: judge whether the left subtree or right subtree is balanced tree
        MyInteger leftDepth = new MyInteger();
        MyInteger rightDepth = new MyInteger();
        boolean leftBalanced = helper(root.left, leftDepth);
        boolean rightBalanced = helper(root.right, rightDepth);

        if (leftBalanced && rightBalanced) {
            if (Math.abs(leftDepth.value - rightDepth.value) <= 1) {
                depth.value = leftDepth.value > rightDepth.value ? leftDepth.value + 1 : rightDepth.value + 1;
                return true;
            } else
                return false;
        }
        return false;
    }

}