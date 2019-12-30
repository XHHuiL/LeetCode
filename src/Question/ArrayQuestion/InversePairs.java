package Question.ArrayQuestion;


public class InversePairs {

    /**
     * 获取数组中逆序对的数目
     * 需要注意到，对数组进行排序的过程便是消除逆序对的过程，所以我们可以为已有的排序算法添加统计逆序对数目的功能
     * 但并不是所有的排序算法都可以，需要是稳定的排序算法
     * 所以我们为归并排序添加统计逆序对数目的功能
     */
    public int inversePairs(int[] array) {
        if (array == null || array.length <= 1)
            return 0;
        // attention: not modify the input without give condition
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return merge(copy, 0, copy.length - 1);
    }

    // method 1: use bubble sort, but the time complexity is a little high
    private int bubble(int[] array){
        int len = array.length;
        int count = 0;
        for (int i = 1; i < len; i++) {
            for (int j = len - 1; j >=i ; j--) {
                if (array[j] < array[j-1]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    count++;
                }
            }
        }
        return count;
    }

    // method 2: use merge sort
    private int merge(int[] array, int start, int end) {
        if (start >= end)
            return 0;

        // step 1: get number of left part and right part
        int mid = (start + end) >> 1;
        int leftNum = merge(array, start, mid);
        int rightNum = merge(array, mid + 1, end);
        // step 2: merge and count
        int count = 0;
        int index = 0;
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[index++] = array[i++];
            } else {
                temp[index++] = array[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid)
            temp[index++] = array[i++];
        while (j <= end)
            temp[index++] = array[j++];
        System.arraycopy(temp, 0, array, start, index);
        return leftNum + rightNum + count;
    }

}