package Question.TreeQuestion;

import Structures.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintByLayer {

    /*
    * 按层次打印的时候，需要使用辅助变量每一层节点的数量，然后就能将不同层的节点分开
    * */
    ArrayList<ArrayList<Integer>> print(TreeNode pRoot){
        if (pRoot == null)
            return new ArrayList<>();
        int cur = 1;
        int next = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            temp.add(node.val);
            cur--;
            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            if (cur == 0){
                result.add(temp);
                temp = new ArrayList<>();
                cur = next;
                next = 0;
            }
        }

        return result;
    }

}