package Question.NumberQuestion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> find(int sum) {
        if (sum <= 2)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        int end = sum / 2 + 1;
        int temp = 0;
        // case 1: 如果小于sum，那么添加在末尾一个新的数
        // case 2: 如果大于sum，那么移除第一个数
        // case 3: 如果连续序列的值等于sum，那么将这个连续序列返回
        int i = 1;
        while (i <= end) {
            if (temp < sum) {
                deque.add(i);
                temp += i;
                i++;
            }
            if (temp > sum) {
                temp -= deque.remove();
            }
            if (temp == sum) {
                ArrayList<Integer> list = new ArrayList<>(deque);
                result.add(list);
                temp -= deque.remove();
            }
        }
        return result;
    }

}