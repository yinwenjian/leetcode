package com.leetcode.t700;

/**
 * @author wenjianyin
 * https://leetcode-cn.com/problems/binary-search/
 */
public class T704BinarySearch {

    public int search(int[] nums, int target) {
        int low = 0;
        int hight = nums.length-1;
        while (low <= hight) {
            int index = low + ((hight-low))/2;
            if(nums[index] == target) {
                return index;
            }else if(nums[index] > target) {
                hight = index - 1;
            }else if(nums[index] < target) {
                low = index + 1;
            }
        }
        return -1;

    }
}
