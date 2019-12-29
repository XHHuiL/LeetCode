package Question.HeapQuestion;

import java.util.ArrayList;

/**
 * Attention: The solution to this kind of problem is to use a maximum heap or minimum heap
 * Attention: to sore the minimum or maximum data
 */
public class TopK {

    public ArrayList<Integer> getMinK(int[] input, int k) {
        // filter
        if (input == null || input.length == 0 || k <= 0 || input.length < k)
            return new ArrayList<>();

        // step 1: construct a maximum heap with size k
        for (int i = k >> 1; i >= 0; i--) {
            adjustDown(input, i, k);
        }

        // step 2: add the remains into this heap
        for (int i = k; i < input.length; i++) {
            // add new smaller element to maximum heap
            if (input[i] < input[0]) {
                int temp = input[0];
                input[0] = input[i];
                input[i] = temp;
                adjustDown(input, 0, k);
            }
        }

        // step 3: return the min k numbers
        for (int i = k - 1; i >= 0; i--) {
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;
            adjustDown(input, 0, i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private void adjustDown(int[] array, int index, int end) {
        int value = array[index];
        for (int i = (index << 1) + 1; i < end; i = (i << 1) + 1) {
            // get the bigger child
            if (i < end - 1 && array[i] < array[i + 1])
                i = i + 1;
            if (array[i] > value) {
                array[index] = array[i];
                array[i] = value;
                index = i;
            } else
                break;
        }
    }

}