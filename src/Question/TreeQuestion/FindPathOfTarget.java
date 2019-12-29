package Question.TreeQuestion;

import Structures.Tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class FindPathOfTarget {

    public ArrayList<ArrayList<Integer>> FindPath(BinaryTreeNode root, int target) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // attention: use double queue to store the values of path
        Deque<Integer> queue = new LinkedList<>();
        helper(root, target, 0, result, queue);
        return result;
    }

    private void helper(BinaryTreeNode root, int target, int sum, ArrayList<ArrayList<Integer>> result, Deque<Integer> queue) {
        queue.add(root.getValue());
        int temp = sum + root.getValue();
        // attention: path if from root to leaf node (not branch node)
        if (root.getLeftNode() == null && root.getRightNode() == null && temp == target) {
            // construct path
            ArrayList<Integer> path = new ArrayList<>(queue);
            result.add(path);
            queue.removeLast();
        } else {
            BinaryTreeNode left = root.getLeftNode();
            BinaryTreeNode right = root.getRightNode();
            if (left != null)
                helper(left, target, temp, result, queue);
            if (right != null)
                helper(right, target, temp, result, queue);
            queue.removeLast();
        }
    }

}