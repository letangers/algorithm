package algorithm.basic.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法
 * <p>
 * 思路：
 * 1. 一次遍历：遍历给定的无序数组，依次判断相邻两个元素的顺序，若顺序不正确则交换二者的位置。
 * 2. 上述的一次遍历可以把数组中最大的(正序排序) 或者 最小的(倒序排序) 元素确定下来，反复执行第1步，直到确定所有元素的位置。
 * <p>
 * 时间复杂度：O(n2)
 */
public class $01_BubbleSort {

    /**
     * 冒泡排序（正序）
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 顺序错误，交换位置
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 22, -11, 53, 2521, 234};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
