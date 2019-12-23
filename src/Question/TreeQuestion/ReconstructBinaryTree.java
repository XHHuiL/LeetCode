package Question.TreeQuestion;

import Structures.Tree.BinaryTreeNode;

public class ReconstructBinaryTree {

    /*
     * test case 1: input empty prefix sequence or empty infix sequence
     * expect: return null BinaryTreeNode
     * */
    private static void testCase_EmptyPrefixOrEmptyInfix() {
        assert reconstructBinaryTree(new int[]{}, new int[]{}) == null;
        System.out.println("Pass: testCase_EmptyPrefixOrEmptyInfix");
    }

    /*
     * test case 2: input correct prefix sequence and infix sequence of a binary tree with one node
     * expect: return correct root of this binary tree
     * */
    private static void testCase_CorrectPrefixAndInfixOneNode() {
        BinaryTreeNode node = reconstructBinaryTree(new int[]{1}, new int[]{1});
        assert node.getValue() == 1;
        System.out.println("Pass: testCase_CorrectPrefixAndInfixOneNode");
    }

    /*
     * test case 3: input correct prefix sequence and infix sequence of a binary tree with several node
     * expect: return correct root of this binary tree
     * */
    private static void testCase_CorrectPrefixAndInfixSeveralNode() {
        BinaryTreeNode node = reconstructBinaryTree(new int[]{1, 2, 3}, new int[]{2, 1, 3});
        assert node.getValue() == 1;
        assert node.getLeftNode().getValue() == 2;
        assert node.getRightNode().getValue() == 3;
        System.out.println("Pass: testCase_CorrectPrefixAndInfixSeveralNode");
    }

    /*
     * test case 4: input correct prefix sequence and infix sequence of a binary tree with complex structure
     * expect: return correct root of this binary tree
     * */
    private static void testCase_CorrectPrefixAndInfixComplexStructure() {
        BinaryTreeNode node1 = reconstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        assert node1.getValue() == 1;

        BinaryTreeNode node2 = node1.getLeftNode();
        assert node2 != null;
        assert node2.getValue() == 2;

        BinaryTreeNode node3 = node1.getRightNode();
        assert node3 != null;
        assert node3.getValue() == 3;

        BinaryTreeNode node4 = node2.getLeftNode();
        assert node4 != null;
        assert node4.getValue() == 4;

        BinaryTreeNode node5 = node3.getLeftNode();
        assert node5 != null;
        assert node5.getValue() == 5;

        BinaryTreeNode node6 = node3.getRightNode();
        assert node6 != null;
        assert node6.getValue() == 6;

        BinaryTreeNode node7 = node4.getRightNode();
        assert node7 != null;
        assert node7.getValue() == 7;

        BinaryTreeNode node8 = node6.getLeftNode();
        assert node8 != null;
        assert node8.getValue() == 8;

        System.out.println("Pass: testCase_CorrectPrefixAndInfixComplexStructure");
    }

    /**
     * Give prefix sequence and infix sequence, then reconstruct corresponding binary tree.
     *
     * @param pre the prefix sequence
     * @param in  th infix sequence
     */
    public static BinaryTreeNode reconstructBinaryTree(int[] pre, int[] in) {
        return reconstructBinaryTreeHelper(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private static BinaryTreeNode reconstructBinaryTreeHelper(int[] prefix, int[] infix, int pre_left, int pre_right, int in_left, int in_right) {
        // step 1: in_left > in_right, which means a null. in_left == in_right, which means a new binary tree node
        if (in_left > in_right)
            return null;

        if (in_left == in_right)
            return new BinaryTreeNode(infix[in_left]);

        // step 2: get position of a root node in infix sequence, then partition it's left sub tree and right sub tree according to this position
        // get sub tree root value
        int value = prefix[pre_left];
        int position = 0;

        // get position
        for (int i = in_left; i <= in_right; i++) {
            if (infix[i] == value) {
                position = i;
                break;
            }
        }

        // partition
        // the left sub tree
        int left_num = position - in_left;
        int l_pre_left = pre_left + 1;
        int l_pre_right = l_pre_left + left_num - 1;
        int l_in_left = in_left;
        int l_in_right = position - 1;

        // the right sub tree
        int right_num = in_right - position;
        int r_pre_left = pre_left + left_num + 1;
        int r_pre_right = r_pre_left + right_num - 1;
        int r_in_left = position + 1;
        int r_in_right = in_right;

        // step 3: construct a binary tree node, reconstruct it's left sub tree and right sub tree
        BinaryTreeNode node = new BinaryTreeNode(value);
        node.setLeftNode(reconstructBinaryTreeHelper(prefix, infix, l_pre_left, l_pre_right, l_in_left, l_in_right));
        node.setRightNode(reconstructBinaryTreeHelper(prefix, infix, r_pre_left, r_pre_right, r_in_left, r_in_right));

        return node;
    }

    public static void main(String[] args) {
        testCase_EmptyPrefixOrEmptyInfix();
        testCase_CorrectPrefixAndInfixOneNode();
        testCase_CorrectPrefixAndInfixSeveralNode();
        testCase_CorrectPrefixAndInfixComplexStructure();
    }

}