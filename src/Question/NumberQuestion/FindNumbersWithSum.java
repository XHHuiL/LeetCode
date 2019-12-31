package Question.NumberQuestion;

import java.util.ArrayList;

public class FindNumbersWithSum {

    /*
     * 描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     * */
    public ArrayList<Integer> find(int[] array, int sum) {
        if (array == null || array.length == 0)
            return new ArrayList<>();
        int p1 = 0;
        int p2 = array.length - 1;
        while (p1 < p2) {
            int temp = array[p1] + array[p2];
            if (temp == sum) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(array[p1]);
                result.add(array[p2]);
                return result;
            } else if (temp < sum) {
                p1++;
            } else
                p2--;
        }
        return new ArrayList<>();
    }

}