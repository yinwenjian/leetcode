package com.leetcode.t200;

/**
 * @author wenjianyin
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class T278FirstBadVersion {
    public int firstBadVersion(int n) {
        int lastGood = 0;
        int firstBad = n;
        while ((firstBad - lastGood) > 1) {
            int mid = lastGood + ((firstBad - lastGood)>>1);
            if (isBadVersion(mid)) {
                firstBad = mid;
            }else {
                lastGood = mid;
            }
        }
        return firstBad;

    }
    public boolean isBadVersion(int num) {
        return false;
    }
}
