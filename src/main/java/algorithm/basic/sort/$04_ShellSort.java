package algorithm.basic.sort;

import java.util.Arrays;

/**
 * 希尔排序算法（缩小增量排序）
 * <p>
 * 改进的插入排序，考虑插入排序的特性：数组本身有序性越强，排序效率越高。希尔排序在插入排序的基础上，增加了外层的控制条件，尽可能
 * 使得进行插入排序时的数组大致有序。
 * <p>
 * 希尔排序引入增量序列的概念：
 * 设定一个增量值，在逻辑上将数组以增量值为间隔分成多个增量序列。
 * 例：
 * arr = {1, 22, -20, 33, 6, 88}
 * 指定增量值为3，那么
 * arr[0] 和 arr[3]为一个增量序列
 * arr[1] 和 arr[4]为一个增量序列
 * arr[2] 和 arr[5]为一个增量序列
 * <p>
 * 算法描述：
 * 1. 设定一个较大的增量值，将数组分为多个逻辑上的增量序列，对每个序列内部进行插入排序
 * 2. 缩小增量值（可以缩小成1/2）,重复第1步；直到增量值缩小为1
 * <p>
 * 分析：
 * 该算法的复杂度取决于对增量序列的分割，按照这种二分的方式在最坏情况下复杂度是O(n2)
 *
 * @see $03_InsertSort
 */
public class $04_ShellSort {

    public static void shellSort(int[] arr) {
        for (int inc = arr.length / 2; inc > 0; inc /= 2) {
            for (int i = inc; i < arr.length; i++) {
                insertSort(arr, inc, i);
            }
        }
    }

    private static void insertSort(int[] arr, int inc, int i) {
        int current = arr[i];
        while (i - inc >= 0 && current < arr[i - inc]) {
            arr[i] = arr[i - inc];
            i = i - inc;
        }
        arr[i] = current;
    }

    public static void main(String[] args) {
        int[] arr = {3, 22, -11, 53, 2521, 234};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
