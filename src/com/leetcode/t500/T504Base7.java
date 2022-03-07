package com.leetcode.t500;

import java.util.Scanner;

/**
 * @author wenjianyin
 * https://leetcode-cn.com/problems/base-7
 */
public class T504Base7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNext()) {
                boolean flag = false;
                StringBuilder outPut = new StringBuilder();
                int num = scanner.nextInt();
                if (num < 0) {
                    flag = true;
                    num = ~num + 1;
                }
                while (true) {
                    int mod = num % 7;
                    int result = num / 7;
                    outPut.append(mod);
                    if (result == 0) {
                        break;
                    }
                    if (result < 7 && mod == 0) {
                        outPut.append(result);
                        break;
                    }
                    num = result;
                }
                if (flag) {
                    System.out.println(outPut.append("-").reverse());
                }
                System.out.println(outPut.reverse());
            }
        } catch (Exception e) {
            System.out.println(111);
        }

    }

    public String convertToBase7(int num) {
        boolean flag = false;
        StringBuilder outPut = new StringBuilder();
        if (num < 0) {
            flag = true;
            num = ~num + 1;
        }
        while (true) {
            int mod = num % 7;
            int result = num / 7;
            outPut.append(mod);
            if (result == 0) {
                break;
            }
            if (result < 7 && mod == 0) {
                outPut.append(result);
                break;
            }
            num = result;
        }
        if (flag) {
            outPut.append("-");
        }
        return outPut.reverse().toString();

    }
}
