package indi.rui.algorithm._1_两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yaowr
 * @create: 2022-12-11
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2,5,7,3};
        int target = 9;
        System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//    }
}
