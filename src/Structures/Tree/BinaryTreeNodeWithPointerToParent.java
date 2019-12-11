package Structures.Tree;

public class BinaryTreeNodeWithPointerToParent {

    private int value;
    private BinaryTreeNodeWithPointerToParent leftNode;
    private BinaryTreeNodeWithPointerToParent rightNode;
    private BinaryTreeNodeWithPointerToParent parentNode;

    public BinaryTreeNodeWithPointerToParent(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNodeWithPointerToParent getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNodeWithPointerToParent leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNodeWithPointerToParent getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNodeWithPointerToParent rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryTreeNodeWithPointerToParent getParentNode() {
        return parentNode;
    }

    public void setParentNode(BinaryTreeNodeWithPointerToParent parentNode) {
        this.parentNode = parentNode;
    }
}