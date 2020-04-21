package algorithm.basic.sort;

import java.util.Arrays;

/**
 * 插入排序算法
 * <p>
 * 思路：
 * 1. 一次遍历：将数组分为有序和无序两部分，每次取出无序部分中的第一个元素，然后一次和有序部分的元素比较，直到找到对应位置插入
 * 2. 多次重复第1步，直到无序部分没有元素
 * <p>
 * 时间复杂度：O(n2)
 */
public class $03_InsertSort {

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int toInsert, insertIndex;
        for (int i = 1; i < arr.length; i++) {
            toInsert = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] > toInsert) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 插入
            arr[insertIndex + 1] = toInsert;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 22, -11, 53, 2521, 234};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
