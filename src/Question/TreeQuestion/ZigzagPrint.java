package Question.TreeQuestion;

import Structures.Tree.BinaryTreeNode;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Stack;

public class ZigzagPrint {

    public ArrayList<ArrayList<Integer>> zigzagPrint(BinaryTreeNode root) {
        // attention: use two stacks to implement this function
        // attention: the order of adjacent layers needs to be reversed and no need to use flag
        if (root == null)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        Stack<BinaryTreeNode> oddStack = new Stack<>();
        Stack<BinaryTreeNode> evenStack = new Stack<>();

        oddStack.push(root);
        while (!oddStack.isEmpty()) {
            ArrayList<Integer> oddLayer = new ArrayList<>();
            while (!oddStack.isEmpty()) {
                BinaryTreeNode node = oddStack.pop();
                oddLayer.add(node.getValue());
                if (node.getLeftNode() != null)
                    evenStack.push(node.getLeftNode());
                if (node.getRightNode() != null)
                    evenStack.push(node.getRightNode());
            }
            results.add(oddLayer);
            if (!evenStack.empty()) {
                ArrayList<Integer> evenLayer = new ArrayList<>();
                while (!evenStack.isEmpty()) {
                    BinaryTreeNode node = evenStack.pop();
                    evenLayer.add(node.getValue());
                    if (node.getRightNode() != null)
                        oddStack.push(node.getRightNode());
                    if (node.getLeftNode() != null)
                        oddStack.push(node.getLeftNode());
                }
                results.add(evenLayer);
            }
        }
        return results;
    }

}