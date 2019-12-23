package Question.ArrayQuestion;

public class ReorderArray {

    /*
    * move all odd numbers to the front of even numbers
    * and maintain the relative positions between odd numbers and between even numbers
    * attention: due to the need to maintain the relative position, so you can only swap from left to right
    *  attention: Time Complexity O(n^2)
    * */
    public void reorderArray(int[] array){
        if (array == null || array.length == 0)
            return;
        for (int i = 1; i < array.length; i++) {
            if ((array[i] & 1) == 0)
                continue;
            int j = i;
            while (j > 0 && (array[j-1] & 1) == 0){
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
        }
    }

}