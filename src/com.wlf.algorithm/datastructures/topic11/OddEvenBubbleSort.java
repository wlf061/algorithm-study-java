package com.wlf.algorithm.datastructures.topic11;

import java.util.concurrent.CountDownLatch;

/**
 * 并行的奇偶冒泡排序：
 * 奇偶交换排序： 将排序分为两个阶段，奇交换和偶交换；
 * 奇交换： 总是比较奇数索引以及相邻的后续元素
 * 偶交换： 总是比较偶数索引以及相邻的后续元素
 * 程序停止的时机：程序不进行交换，且当前进行的是偶交换（奇偶交换已经成对出现）
 *
 * @author nancy.wang
 * @Time 2019/1/29
 */
public class OddEvenBubbleSort {
    //奇偶交换的串行实现
    public static void oddEventSort(int[] arr) {
        int exchFlag = 1, start = 0;
        while (exchFlag == 1 || start == 1) {
            exchFlag = 0;
            for (int i = start; i < arr.length - 1; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    exchFlag = 1;
                }
            }
            if (start == 0) {
                start = 1;
            } else {
                start = 0;
            }
        }
    }
}
