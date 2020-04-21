package algorithm.basic.search;

/**
 * 顺序查找
 * <p>
 * 适用场景：任意数组
 * 时间复杂度 O(n)
 */
public class SequenceSearch {

    /**
     * @param array  给定的一维数组
     * @param target 要查找的目标元素
     * @return 返回目标元素在数组中的下标，没有则返回-1
     */
    public static int sequenceSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 13, 5, -20, 11, 31};
        int target = 31;
        System.out.println(sequenceSearch(arr, target));
    }
}
