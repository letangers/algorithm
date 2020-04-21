package algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }


    /**
     * 测试程序
     * 生成随机长度的数组，为其中每个元素生成随机值
     */
    public static void main(String[] args) {
        // 测试用例的个数
        int testCaseCount = 10000;

        // 每个测试数组的最大长度
        int arrayMaxLength = 1000;

        // 数组中元素的最大值
        int elementMaxValue = 1000;

        int arrayLength = 0, nums[] = new int[0], target = 0;

        try {
            for (int i = 0; i < testCaseCount; i++) {
                arrayLength = (int) (Math.random() * arrayMaxLength) + 1;
                nums = generateTestCase(arrayLength, elementMaxValue);
                target = nums[(int) (Math.random() * arrayLength)];

                int[] result = twoSum(nums, target);

                if (result != null) {
                    System.out.println(i + "  " + Arrays.toString(result) + " : " + nums[result[0]] + " + " + nums[result[1]] + " == "
                            + target + " ? " + (nums[result[0]] + nums[result[1]] == target));

                    // 打印验证未通过的测试用例
                    if (nums[result[0]] + nums[result[1]] != target) {
                        System.err.println(Arrays.toString(nums));
                    }
                } else {
                    System.out.println(i + "  null");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(arrayLength);
            System.err.println(Arrays.toString(nums));
            System.err.println(target);
        }

    }

    /**
     * 随机生成指定长度的数组
     *
     * @param arrayLength 数组长度
     * @param max         随机元素的最大值
     * @return
     */
    public static int[] generateTestCase(int arrayLength, int max) {
        int[] testArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            testArray[i] = (int) (Math.random() * max);
        }
        return testArray;
    }

}
