package algorithm.basic.search;

/**
 * 二分查找算法
 * <p>
 * 适用场景：给定的集合必须有序
 * 时间复杂度 O(log n)
 */
public class BinarySearch {

    /**
     * @param arr    给定的一维数组(这里假设正序)
     * @param target 要查找的目标元素
     * @return 返回目标元素在数组中的下标，没有则返回-1
     */
    public static int binarySearchWithLoop(int[] arr, int target) {

        int left = 0;
        int right = arr.length;
        int middle;

        while (left < right) {
            // 这里采用位运算，防止数组过大的情况下，出现：left + right > Integer.MAX_VALUE
            middle = left + ((right - left) >> 1);
            if (arr[middle] == target) {
                return middle;
            }

            if (arr[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }


    /**
     * 递归方式实现
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchRecursively(int[] arr, int target, int left, int right) {
        if (left >= right) {
            return -1;
        }
        int middle = left + ((left + right) >> 1);
        if (arr[middle] == target) {
            return  middle;
        }
        if (arr[middle] > target) {
            return binarySearchRecursively(arr, target, left, middle - 1);
        } else {
            return binarySearchRecursively(arr, target, middle + 1, left);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5, 5};
        int target = 5;
        int resultWithLoop = binarySearchWithLoop(arr, 5);
        int resultWithRecursive = binarySearchRecursively(arr, 5, 0, arr.length);
        System.out.println(resultWithLoop + " == " + resultWithRecursive + " ? " + (resultWithLoop == resultWithRecursive));
    }
}
