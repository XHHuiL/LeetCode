package Questions.ArrayQuestions;

public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int[] array) {
        // filter
        if (array == null || array.length == 0)
            return 0;

        // solution 1
        //return minInOrder(rotateArray, 0, rotateArray.length - 1);

        // solution 2
        return min(array);
    }

    /*
     * Average Time Complexity: O(n)
     * */
    private int minInOrder(int[] array, int start, int end) {
        // attention: traverse this array and find the first element that smaller than the element in front of it
        for (int i = start; i <= end; i++) {
            if (array[i] < array[i - 1])
                return array[i];
        }
        // attention: if don't find such element, which means this array doesn't rotate, then return the first element
        return array[start];
    }

    /*
     * Average Time Complexity: O(lgn)
     * */
    private int min(int[] array) {
        // attention: you can solve this problem more efficiently by binary search
        // attention: this array is still sorted in two parts, such as 4 5 6 1 2 3, 4 5 6 and 1 2 3 are still ordered
        int start = 0;
        int end  = array.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            // attention: if array[start] == array[mid] == array[end], you can not decide which part it belongs to
            // attention: so, you should get the min value in order in this range
            if (array[start] == array[mid] && array[mid] == array[end])
                return minInOrder(array, start, end);
            if (array[mid] <= array[end])
                end = mid;
            else
                start = mid + 1;
        }
        return array[start];
    }
}