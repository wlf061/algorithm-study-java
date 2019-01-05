package com.wlf.algorithm.chapter2;

/**
 * 牛课堂算法精讲直播讲座（2016） 左程云> 第二章 > 牛课堂第二章
 * https://www.nowcoder.com/live/11/2/1
 * @author nancy.wang
 * @Time 2018/12/27
 */
public class SubArray {

    /*查找子数组的最大和问题：第一题的算法原型
    * 解题思路：
    * 1. 定义两个变量： result 和current, result用来表示sum, current 用来记录从左到右的遍历的累加和
    * 2. 遍历过程中，如果current 小于0 那么current 置为0(简单点理解， 你都为负数，为什么我还需要你加入到我的子数组里来拉低我的sum.).
    *  重新计算。
    * 3. 每次遍历时,比较result 和current 的大小. result保存比较大的值
    *
    *
    * */
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null) {
            return 0;
        }
        int current = array[0];
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            current = current < 0 ? 0 : current;
            current = current + array[i];
            result = Math.max(result, current);
        }
        return result;
    }


    /*
    * 查找两个子数组最大的累加和问题.第一题
    * * 解题思路：
    * 1. 存在子数组就有一个遍历的下标i,数组分为从0~i, i+1 ~ length -1
    * 2. 分成两个辅助数组，分别存储 0~i 和i~ length-1 的子数组的最大和
    * 3. 最后只需要求两个数组对应位置的最大和即可。
    * 4. 这里考虑到遍历分界点和 求 0~i的子数组的最大和 可以同步， 省去一个数组.
    *
    * */
    public int findGreatestSumOfTwoSubArray(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        //初始化数组R.R[i] 表示从 i 到 array.length - 1 中 子数组的最大sum
        int[] R = new int[array.length];
        R[array.length - 1] = array[array.length - 1];
        int current = array[array.length - 1];
        for (int index = array.length - 2; index < array.length; index++) {
            current = current < 0 ? 0 : current;
            current += array[index];
            R[index] = Math.max(R[index + 1], current);
        }
        //开始求不同的分界点i的子数组[0,...,i]和[i+1, array.length -1] 的最大和
        int totalResult = array[0] + R[1];
        int rResult = array[0];
        int rCurrent = array[0];
        for (int index = 1; index < array.length; index++) {
            rCurrent = rCurrent < 0 ? 0 : rCurrent;
            rCurrent += array[index];
            rResult = Math.max(rResult, rCurrent);
            totalResult = Math.max(totalResult, rResult + R[index + 1]);
        }
        return totalResult;
    }



    public static void main(String[] str) {
        int[] test = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(new SubArray().findGreatestSumOfSubArray(test));
    }
}
