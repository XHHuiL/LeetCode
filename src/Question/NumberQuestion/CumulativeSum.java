package Question.NumberQuestion;

public class CumulativeSum {

    /*
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
     * 由于上述限制，通过公式和显示循环求解问题是不可能的，所以需要利用到语言的其他特性来求解
     * */
    public int sum(int n) {
        // solution 1: 使用Math.pow和>>实现 n*(n+1) / 2
        // return (int)(Math.pow(n, 2) + n) >> 1;

        // solution 2: 利用&&的短路特性来终止递归
        int result = n;
        boolean flag = (result > 1) && ((result += sum(n - 1)) > 0);
        return result;
    }
}