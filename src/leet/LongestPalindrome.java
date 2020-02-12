package leet;

public class LongestPalindrome {

    // 最长回文字符串
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        return byExpandFromCenter(s);
    }

    // 方法一：从中心开始扩展，由于子串的长度有奇偶两种情况，要分别考虑
    // 时间复杂度为O(n^2)，空间复杂度为O(1)
    private String byExpandFromCenter(String s){
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 取奇数长度和偶数长度两种情况的最大值
            int len = Math.max(expandFromCenter(s, i, i), expandFromCenter(s, i, i + 1));
            if (len > end - start + 1) {
                start = i - ((len - 1) >> 1);
                end = i + (len >> 1);
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

}
