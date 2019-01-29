package com.wlf.algorithm.datastructures.topic11;

/**
 * 归并排序：
 * 归并排序的核心是： 用的是分治的思想，重点是理解递推公司和merge合并函数；
 * 归并的时间复杂度 是O（N * logn）, 不是原地排序，需要的空间复杂度为O(n)
 * 归并排序 是先一次次分区，但是并不保证有序，最后一次次的merge 保证有序。和快排是个相反的过程
 *
 * @author nancy.wang
 * @Time 2019/1/28
 */
public class MergeSort {

    //归并排序算法
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    //递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {
        //递归终止条件
        if (p >= r) return;

        int q = p + (r - p) / 2;

        //分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        //判断哪个子数组中有剩余的数据
        int start = i, end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        //将剩余的数据拷贝到临时数组tmp 中
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        //将tmp 中的数组拷贝回a[p...r]
        for (i = 0; i <= r - p; i++) {
            a[p + i] = tmp[i];
        }


    }

    public static void main(String[] str) {
        int a[] = {1,6,5,2,3,4};
        mergeSort(a, a.length);
        for (int index = 0; index < a.length; index++) {
            System.out.println(a[index]);
        }
    }


}
