package Question.StackQuestion;

import java.util.Stack;

/**
 * user another stack to store the smallest element after each push
 */
public class StackWithMinFunction {
    private int min = 0;
    private int size = 0;
    private Stack<Integer> values = new Stack<>();
    private Stack<Integer> mins = new Stack<>();


    public void push(int node) {
        if (size == 0)
            min = node;
        else if (node < min)
            min = node;
        size++;
        values.push(node);
        mins.push(min);
    }

    public void pop() {
        size--;
        values.pop();
        mins.pop();
        min = mins.peek();
    }

    public int top() {
        return values.peek();
    }

    public int min() {
        return min;
    }

}