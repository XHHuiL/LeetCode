package Question.ListQuestion;

import Structures.List.ListNode;

public class FindFirstCommonNode {

    /*
    * 首先计算两个链表的长度，然后使用两个指针进行移动直到两个指针指向同一个节点
    * 注意：指向长度较长的那个链表的指针要先移动
    * */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        ListNode longer;
        ListNode shorter;
        if (length1 > length2) {
            longer = pHead1;
            shorter = pHead2;
        } else {
            longer = pHead2;
            shorter = pHead1;
        }
        for (int i = 0; i < Math.abs(length1 - length2); i++) {
            longer = longer.getNext();
        }

        while (longer != null) {
            if (longer == shorter)
                return longer;
            longer = longer.getNext();
            shorter = shorter.getNext();
        }

        return null;
    }

    private int getLength(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }

}