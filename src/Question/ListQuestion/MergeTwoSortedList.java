package Question.ListQuestion;

import Structures.List.ListNode;

public class MergeTwoSortedList {


    /**
     * @param node1 the first sorted list
     * @param node2 the second sorted list
     * @return head of linked list after merging
     */
    public static ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;
        ListNode head;
        if (node1.getVal() <= node2.getVal()) {
            head = node1;
            head.setNext(merge(node1.getNext(), node2));
        } else {
            head = node2;
            head.setNext(merge(node1, node2.getNext()));
        }
        return head;
    }

}