package Question.ArrayQuestion;

public class MoreThanHalfNumber {

    public int solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        // step 1: find the possible value
        int value = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                value = array[i];
                count = 1;
            } else if (array[i] == value)
                count++;
            else
                count--;
        }

        // step 2: verify this value meet condition
        count = 0;
        for (int item : array) {
            if (item == value)
                count++;
        }

        return count > (array.length >> 1) ? value : 0;
    }

}