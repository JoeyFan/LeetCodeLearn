package com.fqh.learn.TwoSum;

import java.util.Arrays;

/**
 * 测试结果
 * 19 / 19 test cases passed.
 * Status: Accepted
 * Runtime: 32 ms
 * Submitted: 0 minutes ago
 * 用时32ms，处于39.41%的水平
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = null;
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (diff == nums[j]) {
                    result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] argus) {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        Solution s = new Solution();
        int[] result = s.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}


/*
3ms的代码
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        short[] map = new short[20050];
        int size = 50;
        for (int i = 0; i < nums.length; i++) {
            map[nums[i] + size] = (short) (i + 1);
            int diff = target - nums[i + 1] + size;
            if (diff < 0) continue;
            short d = map[diff];
            if (d > 0)
                return new int[]{d - 1, i + 1};
        }
        return null;
    }
}*/
