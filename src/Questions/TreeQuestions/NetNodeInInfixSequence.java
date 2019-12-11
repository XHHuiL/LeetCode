package Questions.TreeQuestions;

import Structures.Tree.BinaryTreeNodeWithPointerToParent;

public class NetNodeInInfixSequence {

    /*
    * test case 1: input null reference
    * expect: return null
    * */
    private static void testCase_NullReference(){
        assert getNext(null) == null;
        System.out.println("Pass: testCase_NullReference");
    }

    /*
    * test case 2: get the next node of root node with no right sub tree
    * expect: return null
    * */
    private static void testCase_RootNodeNoRightSubTree(){
        BinaryTreeNodeWithPointerToParent root = new BinaryTreeNodeWithPointerToParent(1);
        assert getNext(root) == null;
        System.out.println("Pass: testCase_RootNodeNoRightSubTree");
    }

    /*
    * test case 3: get next nodes of several nodes
    * expect: return correct next nodes of input nodes
    * */
    private static void testCase_Complex(){
        /*
        * ******** root *******
        * ******* / ***********
        * ***** node1 *********
        * ***** / ** \ ********
        * ** node2 ** node3 ***
        * */
        BinaryTreeNodeWithPointerToParent root = new BinaryTreeNodeWithPointerToParent(0);
        BinaryTreeNodeWithPointerToParent node1 = new BinaryTreeNodeWithPointerToParent(1);
        BinaryTreeNodeWithPointerToParent node2 = new BinaryTreeNodeWithPointerToParent(2);
        BinaryTreeNodeWithPointerToParent node3 = new BinaryTreeNodeWithPointerToParent(3);
        // attention: Sometimes there will occur bugs in test cases, we should avoid this case.
        root.setLeftNode(node1);
        node1.setParentNode(root);
        node1.setLeftNode(node2);
        node2.setParentNode(node1);
        node1.setRightNode(node3);
        node3.setParentNode(node1);
        // case 1: no right sub tree, no parent node
        assert getNext(root) == null;
        // case 2: no right sub tree, has parent node, it's parent's left node
        assert getNext(node2) == node1;
        // case 3: no right sub tree, has parent node, it's parent's right node
        assert getNext(node3) == root;
        // case 4: has right sub tree
        assert getNext(node1) == node3;
        System.out.println("Pass: testCase_Complex");
    }

    /**
     * @param node the node which you need to find it's next node in infix sequence
     * @return the next node in infix sequence
     */
    public static BinaryTreeNodeWithPointerToParent getNext(BinaryTreeNodeWithPointerToParent node){
        // attention: this problem is not difficult but you should consider completely, otherwise you will drop points
        // filter
        if (node == null)
            return null;

        // case 1: no right sub tree and no parent node, obviously it's the root node with no right sub tree, return null directly
        if (node.getRightNode() == null && node.getParentNode() == null)
            return null;

        // case 2: no right sub tree, has parent node, and is the left node of it's parent node, return it's parent node
        if (node.getRightNode() == null && node == node.getParentNode().getLeftNode())
            return node.getParentNode();

        // case 3: no right sub tree, has parent node, and is the right node of it's parent node
        // attention: in this case, it's next node is the ancestor that own a left node first from bottom to top in it's predecessor path
        // attention: if no such ancestor return null ,otherwise return this ancestor
        if (node.getRightNode() == null && node == node.getParentNode().getRightNode()){
            BinaryTreeNodeWithPointerToParent parent = node.getParentNode();
            while (parent.getParentNode() != null && parent == parent.getParentNode().getRightNode())
                parent = parent.getParentNode();
            return parent.getParentNode();
        }

        // case 4: has right sub tree, return the most left node of it's right sub tree
        BinaryTreeNodeWithPointerToParent result = node.getRightNode();
        while (result.getLeftNode() != null)
            result = result.getLeftNode();
        return result;
    }

    public static void main(String[] args) {
        testCase_NullReference();
        testCase_RootNodeNoRightSubTree();
        testCase_Complex();
    }

}