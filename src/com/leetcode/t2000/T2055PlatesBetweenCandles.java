package com.leetcode.t2000;

/**
 * @author wenjianyin
 * https://leetcode-cn.com/problems/plates-between-candles/
 */
public class T2055PlatesBetweenCandles {
    private static final char LAZHU = '|';
    private static final char PANZI = '*';

    public static void main(String[] args) {
        String s = "**|**|**|*";
        int[][] queries = new int[][]{{2, 5}, {1, 6}};
        int[] ints = platesBetweenCandles(s, queries);
        System.out.println(ints);
    }

    public static int[] queryV3(String s, int[][] queries) {
        int length = s.length();
        int[] preSum = new int[length];
        for (int i = 0, count = 0; i < length; i++) {
            if ('*' == s.charAt(i)) {
                count++;
            }
            preSum[i] = count;
        }
        int[] right = new int[length];
        for (int i = 0, l = -1; i < length; i++) {
            if ('|' == s.charAt(i)) {
                l = i;
            }
            right[i] = l;
        }
        int[] left = new int[length];
        for (int i = length - 1, l = -1; i >= 0; i--) {
            if ('|' == s.charAt(i)) {
                l = i;
            }
            left[i] = l;
        }
        int[] ints = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = left[query[0]];
            int y = right[query[1]];
            ints[i] = x == -1 || y == -1 || x > y ? 0 : preSum[y] - preSum[x];
        }
        return ints;
    }


    // leetCode 题解
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return ans;
    }


    public static int queryV2(String s, int left, int right) {
        int count = 0;
        boolean start = false;
        boolean valid = false;
        int allCount = 0;
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            if (c == LAZHU) {
                start = true;
            }
            if (start && c == PANZI) {
                count++;
            }
            if (c == LAZHU && count > 0) {
                valid = true;
                allCount += count;
                count = 0;
            }
        }
        if (valid) {
            return allCount;
        } else {
            return 0;
        }
    }

    public static int query(String s, int left, int right) {
        int count = 0;
        boolean start = false;
        boolean valid = false;
        int allCount = 0;
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            if (c == LAZHU) {
                start = true;
            }
            if (start && c == PANZI) {
                count++;
            }
            if (c == LAZHU && count > 0) {
                valid = true;
                allCount = count + query(s, i, right);
                break;
            }
        }
        if (valid) {
            return allCount;
        } else {
            return 0;
        }
    }
}

