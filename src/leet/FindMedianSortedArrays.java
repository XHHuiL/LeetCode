package leet;

import com.sun.tools.javac.Main;

public class FindMedianSortedArrays {

    /*
     * 找到两个有序数组的中位数，并且要求算法的时间复杂度为O(lg(m + n))
     * nums1和mus2不会同时为空
     * 可以将此问题转化为找到两个排序数组中第k大的数
     * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 将奇数和偶数的情况合并，简化代码
        int left = (len1 + len2 + 1) >> 1;
        int right = (len1 + len2 + 2) >> 1;
        return (findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) +
                findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) / 2;
    }

    /*
     * 找到两个排序数组中第k大的数
     * */
    private double findKth(int[] array1, int start1, int end1, int[] array2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (k < 1 || k > len1 + len2)
            throw new ArrayIndexOutOfBoundsException();

        // 如果数组1比数组2长，那么交换数组1和数组2的顺序，使得数组1的长度<=数组2的长度，这样能简化代码
        if (len1 > len2)
            return findKth(array2, start2, end2, array1, start1, end1, k);
        // 由于数组1一定比数组2短，如果数组1的长度为0，那么说明第k大的数一定在数组2中
        if (len1 == 0)
            return array2[start2 + k - 1];
        // 如果k的值为1，那么说明需要比较数组1和数组2头部的元素，返回较小的那个值即可
        if (k == 1)
            return Math.min(array1[start1], array2[start2]);
        // k的值不为1，说明需要去掉k/2个元素，比较两个数组第k/2个元素的大小，然后决定去掉哪个数组的一部分
        // 注意数组的长度可能不够，所以要取min(len, k / 2)，保证不会出现数组越界异常
        int index1 = start1 + Math.min(len1, k >> 1) - 1;
        int index2 = start2 + Math.min(len2, k >> 1) - 1;
        if (array1[index1] > array2[index2])
            return findKth(array1, start1, end1, array2, index2 + 1, end2, k - (index2 - start2 + 1));
        else return findKth(array1, index1 + 1, end1, array2, start2, end2, k - (index1 - start1 + 1));
    }
}
