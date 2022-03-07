package com.leetcode.t000;

/**
 * @author wenjianyin
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class T35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (right > left) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        if (right == nums.length -1) {
            return ++right;
        }
        return right;
    }

}
