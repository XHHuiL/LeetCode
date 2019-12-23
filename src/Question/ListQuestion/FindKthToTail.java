package Question.ListQuestion;

import Structures.List.ListNode;

public class FindKthToTail {

    /*
     * find the kth node from tail to head
     * */
    public ListNode findKthToTail(ListNode head, int k) {
        // filter
        if (head == null)
            return null;
        if (k <= 0)
            return null;

        ListNode p1 = head;
        ListNode p2 = head;
        // step 1: p1 move k-1 steps first
        while (k > 1) {
            if (p1.getNextNode() != null) {
                p1 = p1.getNextNode();
                k--;
            }else
                return null;
        }

        // step 2: move p2 to target node
        while (p1.getNextNode() != null){
            p1 = p1.getNextNode();
            p2 = p2.getNextNode();
        }

        return p2;
    }

}