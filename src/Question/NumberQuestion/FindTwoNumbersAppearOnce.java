package Question.NumberQuestion;

public class FindTwoNumbersAppearOnce {

    /*
    * 找到一个数组中只出现一次的两个数字，这个问题和“找到数组中只出现一次的一个数字”非常相似
    * “找到数组中只出现一次的一个数字”这个问题十分简单，只需要使用亦或操作即可
    * 所以问题就是如何将两个只出现一次的数字分开。
    * 我们可以先对数组中的所有元素进行一次亦或操作，得到几个结果，此结果一定不为0
    * 然后我们找到这个结果的二进制表示最后边的1所在的位，
    * 根据该位是否为1，可以将原数组中的元素分成两部分，并且需要找的两个数分别处在不同的部分
    * 这两个部分都满足数组中只有一个数字只出现一次，其他数字都出现两次，这样问题就很简单了
    * */
    public void find(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length < 2)
            return;
        // step 1: get result of ^ operation
        int result = 0;
        for (int value : array) {
            result ^= value;
        }

        // step 2: get the most right 1 bit and divide the input array into two parts according this
        int flag = 1;
        while ((result & flag) == 0)
            flag = flag << 1;

        // step 3: calculate
        for (int value : array
        ) {
            if ((value & flag) != 0)
                num1[0] = num1[0] ^ value;
            else
                num2[0] = num2[0] ^ value;
        }
    }

}