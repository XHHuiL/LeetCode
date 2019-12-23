package Question.TreeQuestion;

import Structures.Tree.BinaryTreeNode;

public class HasSubtree {

    /*
     * test case 1: input null reference
     * expect: return false
     * */
    private static void testCase_NullReference() {
        assert !hasSubtree(null, null);
        System.out.println("Pass: testCase_NullReference");
    }

    /*
     * test case 2: input two trees and one is subtree of another
     * expect: return true
     * */
    private static void testCase_HasSubtree() {
        BinaryTreeNode rootA = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        rootA.setLeftNode(node1);
        rootA.setRightNode(node2);
        node1.setLeftNode(node3);
        node1.setRightNode(node4);
        assert hasSubtree(rootA, rootA);
        assert hasSubtree(rootA, node1);
        assert hasSubtree(rootA, node2);
        assert hasSubtree(rootA, node3);
        assert hasSubtree(rootA, node4);
        System.out.println("Pass: testCase_HasSubtree");
    }

    /*
     * test case 3: input two trees and anyone is not subtree of another
     * expect: return false
     * */
    private static void testCase_NoSubtree() {
        BinaryTreeNode rootA = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        rootA.setLeftNode(node1);
        rootA.setRightNode(node2);
        BinaryTreeNode rootB = new BinaryTreeNode(5);
        assert !hasSubtree(rootA, rootB);
        System.out.println("Pass: testCase_NoSubtree");
    }

    /**
     * @param nodeA the bigger tree A
     * @param nodeB the smaller tree B
     * @return whether B is a subtree of A
     */
    public static boolean hasSubtree(BinaryTreeNode nodeA, BinaryTreeNode nodeB) {
        return hasSubtreeHelper(nodeA, nodeB, true);
    }

    private static boolean hasSubtreeHelper(BinaryTreeNode nodeA, BinaryTreeNode nodeB, boolean isRoot) {
        // attention: this question can by solved by recursive function
        // attention: isRoot is used to distinguish to judge subtree or continue to search subtree

        // filter
        if (nodeB == null || nodeA == null)
            return false;
        boolean isSubtree = false;

        // step 1: if values of two roots are same, judge subtree; if not, stop judge subtree or continue search subtree
        if (nodeA.getValue() == nodeB.getValue()) {
            boolean isLeftMatch = nodeB.getLeftNode() == null;
            if (!isLeftMatch)
                isLeftMatch = hasSubtreeHelper(nodeA.getLeftNode(), nodeB.getLeftNode(), false);
            boolean isRightMatch = nodeB.getRightNode() == null;
            if (!isRightMatch)
                isRightMatch = hasSubtreeHelper(nodeA.getRightNode(), nodeB.getRightNode(), false);
            isSubtree = isLeftMatch && isRightMatch;
        } else if (!isRoot)
            return false;

        // step 2: if values of two roots are not same, just continue to search subtree
        return isSubtree || hasSubtreeHelper(nodeA.getLeftNode(), nodeB, true) || hasSubtreeHelper(nodeA.getRightNode(), nodeB, true);
    }

    public static void main(String[] args) {
        testCase_NullReference();
        testCase_HasSubtree();
        testCase_NoSubtree();
    }

}