package Question.ListQuestion;

import Structures.List.RandomListNode;

public class CloneComplexList {

    /**
     * clone a complex list that every node with a random pointer to another node
     * @param pHead the head of random list
     * @return the head of cloned random list
     */
    public static RandomListNode clone(RandomListNode pHead){
        if (pHead == null)
            return null;

        // step 1: clone node and put new node between two adjacent original nodes
        RandomListNode cur = pHead;
        while (cur != null){
            RandomListNode cloned = new RandomListNode(cur.value);
            RandomListNode next = cur.next;
            cur.next = cloned;
            cloned.next = next;
            cur = next;
        }

        // step 2: clone random pointer
        cur = pHead;
        while (cur != null){
            RandomListNode cloned = cur.next;
            RandomListNode random = cur.random;
            if (random != null){
                cloned.random = random.next;
            }
            cur = cloned.next;
        }

        // step 3: partition two random list
        // attention: can't destroy the original list
        cur = pHead;
        RandomListNode clonedHead = cur.next;
        RandomListNode clonedCur = clonedHead;
        while (clonedCur.next != null){
            RandomListNode next = clonedCur.next;
            RandomListNode clonedNext = next.next;
            cur.next = next;
            clonedCur.next = clonedNext;
            cur = next;
            clonedCur = clonedNext;
        }
        cur.next = null;

        return clonedHead;
    }

}