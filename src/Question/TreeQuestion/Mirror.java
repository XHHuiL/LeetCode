package Question.TreeQuestion;

import Structures.Tree.BinaryTreeNode;

public class Mirror {

    /**
     * get the mirror of input tree
     *
     * @param root root of input tree
     */
    public static void mirror(BinaryTreeNode root) {
        // filter
        if (root == null)
            return;

        // step 1: get mirrors of it's left subtree and right subtree
        if (root.getLeftNode() != null)
            mirror(root.getLeftNode());
        if (root.getRightNode() != null)
            mirror(root.getRightNode());

        // step 2: exchange it's left node and right node
        // attention: ths sequence of step 1 and step 2 can reverse
        BinaryTreeNode temp = root.getLeftNode();
        root.setLeftNode(root.getRightNode());
        root.setRightNode(temp);
    }

}