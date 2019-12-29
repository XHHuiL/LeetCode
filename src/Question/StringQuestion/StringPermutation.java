package Question.StringQuestion;

import java.util.ArrayList;
import java.util.Collections;

public class StringPermutation {

    /**
     * get all the permutation of chars in the input string and output them in dictionary order
     */
    public ArrayList<String> permutation(String str) {
        // filter
        if (str == null || str.length() == 0)
            return new ArrayList<>();

        int len = str.length();
        char[] chars = new char[len];
        str.getChars(0, len, chars, 0);
        // step 1: get permutation
        ArrayList<String> result = new ArrayList<>();
        helper(result, chars, 0, len);

        // step 2: sort all the permutation by RadixSort
        String[] strings = new String[result.size()];
        radixSort(result.toArray(strings));
        result.clear();
        Collections.addAll(result, strings);
        return result;
    }

    private void helper(ArrayList<String> result, char[] chars, int index, int len) {
        if (index == len - 1) {
            result.add(new String(chars));
            return;
        }
        char cur = chars[index];
        for (int i = index; i < len; i++) {
            if (i == index || chars[i] != cur) {
                // exchange
                chars[index] = chars[i];
                chars[i] = cur;
                // sub question
                helper(result, chars, index + 1, len);
                // recovery
                chars[i] = chars[index];
                chars[index] = cur;
            }
        }
    }

    private void radixSort(String[] strings) {
        // attention: 主要时间开销在按照每位对数组元素进行排序，总共排序的次数为最大元素的位数次m
        // attention: 所以如果按照每位对数组元素进行排序的时间复杂度为O(n)，那么基数排序总的时间复杂度为O(m*n)
        // attention: 在这里，可以使用26个桶（先进先出队列），运用桶排序
        int size = strings.length;
        int len = strings[0].length();
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                boolean isExchange = false;
                for (int k = size - 1; k > j; k--) {
                    if (strings[k].charAt(i) < strings[k-1].charAt(i)){
                        String temp = strings[k];
                        strings[k] = strings[k-1];
                        strings[k-1] = temp;
                        isExchange = true;
                    }
                }
                if (!isExchange)
                    break;
            }
        }
    }
}