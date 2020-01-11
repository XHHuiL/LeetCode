package Question.ListQuestion;

import Structures.List.ListNode;

public class ReverseList {

    /*
     * reverse the list and return it's new head
     * */
    public ListNode reverseList(ListNode head) {
        // filter
        if (head == null)
            return null;

        // attention: implement this function by traversing this list with tree pointers: pre, cur, next
        ListNode pre = null;
        ListNode cur = head;
        while (cur.getNext() != null){
            ListNode next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        cur.setNext(pre);
        return cur;
    }

}