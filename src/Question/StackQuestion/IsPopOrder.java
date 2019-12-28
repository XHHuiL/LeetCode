package Question.StackQuestion;

import java.util.Stack;

public class IsPopOrder {


    /**
     * @param pushA push sequence
     * @param popA  pop sequence
     * @return whether the pop sequence corresponds to the push sequence
     */
    public boolean isPopOrder(int[] pushA, int[] popA) {
        // attention: we can simulate the process of stack pushing to judge whether the pop sequence meet condition
        if (pushA == null || popA == null)
            return false;
        if (popA.length == 0 || pushA.length != popA.length)
            return false;
        Stack<Integer> temp = new Stack<>();
        int len = pushA.length;

        for (int i = 0, j = 0; i < len;) {
            temp.push(pushA[i++]);
            // attention: you can pop elements while pushing elements
            while (j < len && !temp.empty() && temp.peek() == popA[j]){
                temp.pop();
                j++;
            }
        }

        return temp.empty();
    }

}