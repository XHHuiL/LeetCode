package Question.ArrayQuestion;

public class FindIntegerInTwoDimensionalArray {

    /**
     * @param target target you want to find in this array
     * @param array two-dimensional array Each row is sorted in ascending order from left to right,
     *              and each column is sorted in ascending order from top to bottom
     * @return whether this target in this array or not
     */
    public boolean find(int target, int[][] array){
        // filter
        if (array == null || array.length == 0 || array[0] == null || array[0].length == 0)
            return false;

        // step 1: start from left-bottom
        int row = array.length;
        int column = array[0].length;
        int i = row - 1;
        int j = 0;

        // step 2: search in this array from left-bottom to right-top
        while (i >= 0 && i < row && j >= 0 && j < column){
            int cur = array[i][j];
            if (cur == target)
                return true;
            else if (cur > target)
                i--;
            else
                j++;
        }
        return false;
    }

}