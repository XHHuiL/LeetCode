package Question.TreeQuestion;

import Structures.Tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {

    /**
     * @param root root node of binary tree than to be printed
     * @return a ArrayList contains nodes' values
     */
    public ArrayList<Integer> printFromTopToBottom(BinaryTreeNode root) {
        // attention: this is a breadth first search problem, you can implement it by using a queue
        if (root == null)
            return new ArrayList<>();
        // attention: LinkedList implements the Queue interface
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            results.add(node.getValue());
            if (node.getLeftNode() != null)
                queue.add(node.getLeftNode());
            if (node.getRightNode() != null)
                queue.add(node.getRightNode());
        }
        return results;
    }

}