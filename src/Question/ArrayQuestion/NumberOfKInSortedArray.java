package Question.ArrayQuestion;

public class NumberOfKInSortedArray {

    /*
     * 利用二分查找可以统计k在排序的数组中出现的次数
     * */
    public int numberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        return binarySearch(array, 0, array.length - 1, k);
    }

    private int binarySearch(int[] array, int start, int end, int k) {
        if (start > end)
            return 0;
        int mid = (start + end) >> 1;
        if (array[mid] > k)
            return binarySearch(array, start, mid - 1, k);
        else if (array[mid] < k)
            return binarySearch(array, mid + 1, end, k);
        else {
            int count = 1;
            // attention: should be limited to range [start, end]
            if (mid > start && array[mid - 1] == k)
                count += binarySearch(array, start, mid - 1, k);
            if (mid < end && array[mid + 1] == k)
                count += binarySearch(array, mid + 1, end, k);
            return count;
        }
    }

}