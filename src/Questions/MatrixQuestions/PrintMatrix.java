package Questions.MatrixQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrintMatrix {

    /*
     * test case 1: null
     * expect: return null
     * */

    private static void testCase_NullReference() {
        assert printMatrix(null) == null;
        System.out.println("Pass: testCase_NullReference");
    }

    /*
     * test case 2: square matrix
     * expect: the corresponding value
     * */
    private static void testCase_SquareMatrix() {
        int[][] square = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                square[i][j] = i * 2 + j;
            }
        }

        ArrayList<Integer> result = printMatrix(square);
        assert result.get(0) == 0;
        assert result.get(1) == 1;
        assert result.get(2) == 3;
        assert result.get(3) == 2;
        System.out.println("Pass: testCase_SquareMatrix");
    }


    /**
     * @param matrix the matrix that needed to print
     * @return a ArrayList contain print results clockwise(顺时针)
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        // filter
        if (matrix == null)
            return null;
        ArrayList<Integer> result = new ArrayList<>();

        // step 1: get the row number and column number of this matrix
        int row = matrix.length;
        int column = matrix[0].length;

        // step 2: print this matrix
        int rStart = -1;
        int rEnd = row;
        int cStart = -1;
        int cEnd = column;
        for (int i = 0; i < row; i++) {
            // update the start index and end index
            rStart++;
            rEnd--;
            cStart++;
            cEnd--;
            if (rStart > rEnd || cStart > cEnd)
                break;

            // step 3: print top, right, bottom, left
            // top
            for (int j = cStart; j <= cEnd; j++)
                result.add(matrix[rStart][j]);
            // right
            for (int j = rStart + 1; j <= rEnd; j++)
                result.add(matrix[j][cEnd]);
            // attention: avoid print repeatedly
            // bottom
            if (rEnd > rStart)
                for (int j = cEnd - 1; j >= cStart; j--)
                    result.add(matrix[rEnd][j]);
            // left
            if (cEnd > cStart)
                for (int j = rEnd - 1; j >= rStart + 1; j--)
                    result.add(matrix[j][cStart]);
        }
        return result;
    }

    public static void main(String[] args) {
        testCase_NullReference();
        testCase_SquareMatrix();
    }
}