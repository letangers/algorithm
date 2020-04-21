package algorithm.basic.sort;

import java.util.Arrays;

/**
 * 选择排序算法
 * <p>
 * 思路：
 * 1. 一次遍历：将数组分为前后两部分，前半部分是有序的，后半部分是无序的，一次遍历无序部分，找出其中最小元素，放到有序部分的末尾
 * 2. 重复第1步，直到无序部分没有元素。
 * <p>
 * 时间复杂度：O(n2)
 */
public class $02_SelectionSort {

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }

            // 交换顺序
            if (i != minIndex) {
                arr[i] = arr[i] ^ arr[minIndex];
                arr[minIndex] = arr[i] ^ arr[minIndex];
                arr[i] = arr[i] ^ arr[minIndex];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 22, -11, 53, 2521, 234};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
