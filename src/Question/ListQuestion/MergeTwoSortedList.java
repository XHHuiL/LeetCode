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
        if (node1.getValue() <= node2.getValue()) {
            head = node1;
            head.setNextNode(merge(node1.getNextNode(), node2));
        } else {
            head = node2;
            head.setNextNode(merge(node1, node2.getNextNode()));
        }
        return head;
    }

}