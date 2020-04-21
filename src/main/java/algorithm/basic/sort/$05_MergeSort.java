package algorithm.basic.sort;

import java.util.Arrays;

/**
 * 归并排序算法
 * <p>
 * 归并排序依据分而治之的思想(Divide and Conquer)，核心思路就是将数组分为几个子序列，首先保证子序列各自有序，再合并子序列。
 * 通常我们将带排序的数组一分为二，接着二分为四... 以此类推，即每个子序列都会由它的两个子序列合并而成，这也叫做二路归并。
 * <p>
 * <p>
 * 时间复杂度：O(n * log n)
 * <p>
 * 思考：
 * 算法在很多时候都是以空间来换取时间，在归并排序中也不例外。
 * 下面展示的代码实现中，在每次的merge操作中都会新创建一个right - left + 1长度的数组，空间复杂度为O(n2)，如何改进？
 */
public class $05_MergeSort {

    /**
     * 归并排序 - 递归方式
     *
     * @param arr
     * @return
     */
    public static void mergeSortRecursively(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 将数组一分为二
            int middle = left + ((right - left) >> 1);
            // 对左半部分排序
            mergeSort(arr, left, middle);
            // 对右半部分排序
            mergeSort(arr, middle + 1, right);
            // 合并左右两部分
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int leftIndex = left, rightIndex = middle + 1, mergeIndex = 0;
        while (leftIndex <= middle && rightIndex <= right) {
            // 依次比较左右数组的元素值，较小的值放入新的大数组中
            temp[mergeIndex++] = arr[leftIndex] > arr[rightIndex] ? arr[rightIndex++] : arr[leftIndex++];
        }

        // 若左部分数组有剩余元素，则继续填充到大数组中
        while (leftIndex <= middle) {
            temp[mergeIndex++] = arr[leftIndex++];
        }
        // 若右部分数组有剩余元素，则继续填充到大数组中
        while (rightIndex <= right) {
            temp[mergeIndex++] = arr[rightIndex++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    /**
     * 归并排序 - 非递归方式
     *
     * @param arr
     */
    public static void mergeSortWithLoop(int[] arr) {
        int length = arr.length;
        // 非递归方式从最小单位开始合并
        int mergeSize = 1;
        while (mergeSize < length) {
            int left = 0;
            while (left < length) {
                int middle = left + mergeSize - 1;
                if (middle >= length) {
                    break;
                }
                int right = Math.min(middle + mergeSize, length - 1);
                merge(arr, left, middle, right);
                left = right + 1;
            }
            if (mergeSize > length >> 1) {
                break;
            }
            mergeSize <<= 1;
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 22, -11, 53, 2521, 234};
        mergeSortRecursively(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {3, 22, -11, 53, 2521, 234};
        mergeSortWithLoop(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
