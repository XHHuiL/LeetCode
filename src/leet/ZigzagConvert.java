package leet;

import java.util.ArrayList;
import java.util.LinkedList;

public class ZigzagConvert {

    // Z字形打印字符串
    public static String zigzagConvert(String s, int numRows) {
        return foo(s, numRows);
    }

    /*
     * 方法一：暴力解法，使用辅助的链表存储每行上的字符，最后遍历链表得到结果
     * 时间复杂度为O(n)，空间复杂度为O(n)
     * */
    private static String foo(String s, int numRows) {
        // 过滤
        if (s == null || s.length() == 0)
            return "";
        if (numRows == 1 || numRows >= s.length())
            return s;

        ArrayList<LinkedList<Character>> lists = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++)
            lists.add(new LinkedList<>());

        // 将不同行的字符添加到不同的LinkedList中
        int index = 0;
        boolean down = false;
        for (char c : s.toCharArray()) {
            lists.get(index).add(c);
            // 将不同分支的代码合并，简化代码
            if (index == 0 || index == numRows - 1) down = !down;
            index += down ? 1 : -1;
        }

        // 遍历LinkedList，输出结果
        StringBuilder builder = new StringBuilder();
        for (LinkedList<Character> list : lists) {
            for (Character c : list) {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(zigzagConvert("PAYPALISHIRING", 3));
    }
}
