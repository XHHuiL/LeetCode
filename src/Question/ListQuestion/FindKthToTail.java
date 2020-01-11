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
            if (p1.getNext() != null) {
                p1 = p1.getNext();
                k--;
            }else
                return null;
        }

        // step 2: move p2 to target node
        while (p1.getNext() != null){
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return p2;
    }

}