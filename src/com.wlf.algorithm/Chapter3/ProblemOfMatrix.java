package com.wlf.algorithm.Chapter3;

import com.wlf.algorithm.chapter2.SubArray2;

/**
 * 牛课堂算法精讲直播讲座（2016） > 第三章 > 牛课堂第三章
 *
 * @author nancy.wang
 * @Time 2019/1/8
 */
public class ProblemOfMatrix {

    /****
     * 题目1：给定无序 矩阵， 可正可负，求子矩阵的最大和
     * 假设 矩阵为 n * n, 暴力求解法(计算出所有的子矩阵，然后求其最大值)， 时间复杂度为O(N ^ 6)
     * 1. 矩阵压缩， 计算出所有的压缩矩阵，以 第一行开始的，以第二行开始的。。。。 时间复杂度为O（N * N）.
     * 2. 在求解子矩阵的过程中，求解current 之和，如果 current 为负，则置0，重新计算。
     */
    public int getMaxSumOfSubMatrix(int[][] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        int[] s = null;
        int current = 0;
        int result = 0;

        //注意: 这里是从row 压缩， 时间复杂度 是 O(row.length * row.length * col.length).
        //如果 row > col, 可以从col压缩，减少 遍历次数。
        for (int row = 0; row < array.length; row++) {
            s = new int[array[0].length];
            for (int index = row; index < array.length; index++) {
                current = 0;
                for (int k = 0; k < s.length; k++) {
                    s[k] += array[index][k];
                    current = current < 0 ? 0 : current;
                    current = current + s[k];
                    result = Math.max(result, current);
                }

            }
        }
        return result;
    }

    /***
     * 题目2： 给定一个无序 矩阵， 其中 有 正，有负，有0； 再给定一个K，
     * 求累加和小于或者等于K 的 最大子矩阵大小。矩阵大小用元素的个数表示
     * 解题思路： 1. 矩阵压缩的方式同题目1中一样
     * 2. 算法原型改成了： Chapter2.SubArray2.getLessKMaxLength, 求解子数组和 大于或者等于K
     *
     * @param
     */

    private static int getLessIndex(int[] h, int sum, int index) {
        int low = 0, high = index;
        int mid = 0;
        int res = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (h[mid] >= sum) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public int getMaxLengthOfMatrix(int[][] array, int sum) {
        if (null == array || array.length == 0) {
            return 0;
        }
        int[] s = null;
        int maxLength = 0;
        for (int row = 0; row < array.length; row++) {
            s = new int[array[0].length];
            for (int index = row; index < array.length; index++) {
                for (int k = 0; k < s.length; k++) {
                    s[k] += array[index][k];
                }
                maxLength = Math.max(maxLength, (index - row + 1) * new SubArray2().getLessKMaxLength(s, sum));
            }

        }
        return maxLength;
    }

    public static void main(String[] str) {
        int[][] array = {{3, 2, 1, 4}, {6, 5, -1, 1}, {9, 7, 0, 5}};
        System.out.println(new ProblemOfMatrix().getMaxSumOfSubMatrix(array));
    }
}
