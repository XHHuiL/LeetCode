package Algorithm.SortAlgorithm;

public class SortUtil {

    /*
     * Insert Sort: Insert current element into the sorted sub array
     * Contains: Direct Insert Sort, Binary Insert Sort, Shell Sort.
     * */

    public static void directInsertSort(int[] array) {
        if (array == null || array.length == 0)
            return;
        int length = array.length;
        for (int i = 1; i < length; i++) {
            // todo: to support using comparator to compare two elements
            // search the index that current element should be place
            int index = i;
            while (index > 0 && array[i] < array[index - 1]) {
                index--;
            }
            // swap elements
            for (int j = i; j > index; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    public static void binaryInsertSort(int[] array) {
        if (array == null || array.length == 0)
            return;
        int length = array.length;
        for (int i = 1; i < length; i++) {
            // use binary search to accelerate the search process
            int start = 0;
            int end = i - 1;
            int mid = (start + end) >> 1;
            while (start <= end) {
                if (array[i] < array[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
                mid = (start + end) >> 1;
            }
            int index = start;

            // swap elements
            for (int j = i; j > index; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    public static void shellSort(int[] array) {
        if (array == null || array.length == 0)
            return;
        int length = array.length;
        for (int step = length >> 1; step >= 1; step = step >> 1) {
            for (int i = step; i < length; i++) {
                // search the index that current element should be place
                int index = i;
                // attention: focus on the boundary condition
                while (index >= step) {
                    if (array[index] < array[index - step]) {
                        int temp = array[index];
                        array[index] = array[index - step];
                        array[index - step] = temp;
                        index -= step;
                    } else
                        break;
                }
            }
        }
    }

    /*
     * Exchange Sort: sort array by swapping the positions of adjacent elements
     * Contain; BubbleSort, QuickSort
     * */

    public static void bubbleSort(int[] array) {
        if (array == null || array.length == 0)
            return;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            boolean isExchange = false;
            for (int j = length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isExchange = true;
                }
            }
            if (!isExchange)
                break;
        }
    }

    public static void quickSort(int[] array) {
        if (array == null || array.length == 0)
            return;
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int start, int end) {
        if (start >= end)
            return;
        // step 1: let mid element be pivot and swap array[start] and array[mid]
        int mid = (start + end) >> 1;
        int pivot = array[mid];
        array[mid] = array[start];
        array[start] = pivot;

        // step 2: partition and place pivot in correct position
        int i = start + 1;
        int j = end;
        while (i <= j) {
            // attention: add additional condition to prevent out of boundary
            while (i <= end && array[i] < pivot)
                i++;
            while (j >= start && array[j] >= pivot)
                j--;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int position = i - 1;
        array[start] = array[position];
        array[position] = pivot;

        // step 3: recursive call
        quickSortHelper(array, start, position - 1);
        quickSortHelper(array, position + 1, end);
    }

}