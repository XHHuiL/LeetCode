package Question.ArrayQuestion;

public class FindGreatestSum {

    /**
     * @param array input array contain integer
     * @return the greatest sum of it's subarray
     */
    public int findGreatestSumOfSubArray(int[] array) {
        // filter
        if (array == null || array.length == 0)
            return 0;

        // attention: you can implement this function by using single for loop
        int maxSum = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
            if (sum < array[i])
                sum = array[i];
            if (sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }

}