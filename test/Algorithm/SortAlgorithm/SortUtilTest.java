package Algorithm.SortAlgorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class SortUtilTest {


    @Test
    public void testDirectInsertSort() {
        int[] target = new int[]{1, 2, 3, 4, 5};

        // test case 1: increasing array
        int[] increasingArray = new int[]{1, 2, 3, 4, 5};
        SortUtil.directInsertSort(increasingArray);
        Assert.assertArrayEquals(increasingArray, target);

        // test case 2: decreasing array
        int[] decreasingArray = new int[]{5, 4, 3, 2, 1};
        SortUtil.directInsertSort(decreasingArray);
        Assert.assertArrayEquals(decreasingArray, target);

        // test case 3: normal array
        int[] normalArray = new int[]{4, 2, 3, 1, 5};
        SortUtil.directInsertSort(normalArray);
        Assert.assertArrayEquals(normalArray, target);
    }


    @Test
    public void testBinaryInsertSort() {
        int[] target = new int[]{1, 2, 3, 4, 5};

        // test case 1: increasing array
        int[] increasingArray = new int[]{1, 2, 3, 4, 5};
        SortUtil.binaryInsertSort(increasingArray);
        Assert.assertArrayEquals(increasingArray, target);

        // test case 2: decreasing array
        int[] decreasingArray = new int[]{5, 4, 3, 2, 1};
        SortUtil.binaryInsertSort(decreasingArray);
        Assert.assertArrayEquals(decreasingArray, target);

        // test case 3: normal array
        int[] normalArray = new int[]{4, 2, 3, 1, 5};
        SortUtil.binaryInsertSort(normalArray);
        Assert.assertArrayEquals(normalArray, target);
    }

    @Test
    public void testShellSort() {
        int[] target = new int[]{1, 2, 3, 4, 5};

        // test case 1: increasing array
        int[] increasingArray = new int[]{1, 2, 3, 4, 5};
        SortUtil.shellSort(increasingArray);
        Assert.assertArrayEquals(increasingArray, target);

        // test case 2: decreasing array
        int[] decreasingArray = new int[]{5, 4, 3, 2, 1};
        SortUtil.shellSort(decreasingArray);
        Assert.assertArrayEquals(decreasingArray, target);

        // test case 3: normal array
        int[] normalArray = new int[]{4, 2, 3, 1, 5};
        SortUtil.shellSort(normalArray);
        Assert.assertArrayEquals(normalArray, target);
    }

    @Test
    public void testBubbleSort() {
        int[] target = new int[]{1, 2, 3, 4, 5};

        // test case 1: increasing array
        int[] increasingArray = new int[]{1, 2, 3, 4, 5};
        SortUtil.bubbleSort(increasingArray);
        Assert.assertArrayEquals(increasingArray, target);

        // test case 2: decreasing array
        int[] decreasingArray = new int[]{5, 4, 3, 2, 1};
        SortUtil.bubbleSort(decreasingArray);
        Assert.assertArrayEquals(decreasingArray, target);

        // test case 3: normal array
        int[] normalArray = new int[]{4, 2, 3, 1, 5};
        SortUtil.bubbleSort(normalArray);
        Assert.assertArrayEquals(normalArray, target);
    }

    @Test
    public void testQuickSort() {
        int[] target = new int[]{1, 2, 3, 4, 5};

        // test case 1: increasing array
        int[] increasingArray = new int[]{1, 2, 3, 4, 5};
        SortUtil.quickSort(increasingArray);
        Assert.assertArrayEquals(increasingArray, target);

        // test case 2: decreasing array
        int[] decreasingArray = new int[]{5, 4, 3, 2, 1};
        SortUtil.quickSort(decreasingArray);
        Assert.assertArrayEquals(decreasingArray, target);

        // test case 3: normal array
        int[] normalArray = new int[]{4, 2, 3, 1, 5};
        SortUtil.quickSort(normalArray);
        Assert.assertArrayEquals(normalArray, target);

        // test case 4: duplicate element array
        int[] duplicateArray = new int[]{4, 4, 3, 3, 1, 5, 2, 1, 6};
        target = new int[]{1, 1, 2, 3, 3, 4, 4, 5, 6};
        SortUtil.quickSort(duplicateArray);
        Assert.assertArrayEquals(duplicateArray, target);
    }
}