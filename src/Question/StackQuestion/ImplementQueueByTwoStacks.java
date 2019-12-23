package Question.StackQuestion;

import java.util.NoSuchElementException;
import java.util.Stack;

public class ImplementQueueByTwoStacks {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();


    /**
     * @param node the node that needed to add into this queue
     *             O(1)
     */
    public void add(int node){
        stack1.push(node);
    }


    /**
     * @return the head element's value of this queue, O(1)
     */
    public int remove(){
        if (stack2.empty()){
            // attention: should throw NoSuchElementException if there is no element in both stacks
            if (stack1.empty())
                throw new NoSuchElementException();
            while (!stack1.empty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}