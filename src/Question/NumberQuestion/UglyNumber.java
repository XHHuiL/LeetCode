package Question.NumberQuestion;

public class UglyNumber {

    /*
     * 1 is the first ugly number and return the kth ugly number
     * */
    public int getUglyNumber(int k) {
        if (k < 1)
            return 0;

        int[] result = new int[k];
        result[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1; i < k; i++) {
            int next2 = result[index2] * 2;
            int next3 = result[index3] * 3;
            int next5 = result[index5] * 5;
            int min = Math.min(next2, Math.min(next3, next5));
            // attention: every index that value in it equals min should increase,
            //  otherwise there will be repeated number in result
            if (next2 == min)
                index2++;
            if (next3 == min)
                index3++;
            if (next5 == min)
                index5++;
            result[i] = min;
        }

        return result[k - 1];
    }

}