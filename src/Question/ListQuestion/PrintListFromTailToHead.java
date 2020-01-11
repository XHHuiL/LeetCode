package Question.ListQuestion;

import Structures.List.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead {

    /*
     * test case 1: input null reference
     * expect: return empty ArrayList
     * */
    private static void testCase_NullReference() {
        assert printListFromTailToHead(null).isEmpty();
        System.out.println("Pass: testCase_NullReference");
    }

    /*
     * test case 2: one node
     * expect: return a ArrayList<Integer> contains the value of this node
     * */
    private static void testCase_OneNode() {
        ArrayList<Integer> list = printListFromTailToHead(new ListNode(1));
        assert list != null;
        assert list.size() == 1;
        assert list.get(0) == 1;
        System.out.println("Pass: testCase_OneNode");
    }

    /*
     * test case 3: several node
     * expect: return a ArrayList<Integer> contains the value of this list from tail to head
     * */
    private static void testCase_SeveralNode() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        ArrayList<Integer> list = printListFromTailToHead(node1);
        assert list != null;
        assert list.size() == 4;
        for (int i = 0; i < 4; i++) {
            assert list.get(i) == 4 - i;
        }
        System.out.println("Pass: testCase_SeveralNode");
    }

    /**
     * Since we can only get a specific element from head to tail,
     * the efficiency of double loop solution is ver low.
     * attention: So we should use additional structure to help record the traversed elements.
     * attention: Stack may be a useful structure
     *
     * @param head the head of input list
     * @return an ArrayList contains values of this list from tail to head
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode head) {
        // step 1: filter input
        if (head == null)
            return new ArrayList<Integer>();

        // step 2: traverse the list and record value
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.getVal());
            head = head.getNext();
        }

        // step 3: reverse values
        // attention: When you use below sentence to construct an ArrayList by a stack, stack.toArray() will be called
        // attention: However, this function won't reverse the values in this stack. So you should implement it by yourself
        // ArrayList<Integer> result = new ArrayList<>(stack);
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.empty()){
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        testCase_NullReference();
        testCase_OneNode();
        testCase_SeveralNode();
    }
}