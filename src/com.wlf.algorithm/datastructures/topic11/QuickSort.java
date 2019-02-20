package com.wlf.algorithm.datastructures.topic11;

import java.util.Arrays;

/**
 * 快速排序： 理解快速排序的重点是 partition()分区函数和递归。
 * 快速排序 每次做分区都保证分区内相对于pivot 是有序的， 如果最终分区的大小为1，那么就能完全
 * 进行排序
 * @author nancy.wang
 * @Time 2019/1/29
 */
public class QuickSort {

    //快速排序, a 是数组，n 表示数组的大小
    public static void quickSort(int[] a, int n){
        quickSortInternally(a, 0, n-1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    //我们通过游标 i 把 A[p…r-1] 分成两部分。A[p...i-1]的元素 都是小于pivot 的，
    //暂且叫它 "已处理区间"，A[i...r-1] 是 "未处理区间"， 每次 都从未处理区间
    // 中获取一元素A[j] 与pivot 对比， 小于pivot 就和i 位置交换。

    private static int partition(int[] a, int p, int r){
        int pivot =a[r];
        int i=p;
        for(int j=p; j< r; ++j){
            if(a[j] < pivot){
                if (i == j){
                    i++;
                }
                else{
                    int tmp =a[i];
                    a[i++] = a[j];
                    a[j]=tmp;

                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r]= tmp;
        return i;
    }

    public static void main(String[] str) {
        int a[] = {11,8,3,9,7,1,2,5};
        quickSort(a, a.length);
        for (int index = 0; index < a.length; index++) {
            System.out.println(a[index]);
        }
        //Arrays.sort();
    }
}
