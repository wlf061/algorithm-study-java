package com.wlf.algorithm.datastructures.topic13;

import java.util.Arrays;

/**
 * 计数排序：
 * C[i]: 下标表示 分数,c[i]存储的是小于等于分数k 的考生个数
 * A[i]： 表示分数数组
 * R[i]:  存储的是排序后的分数数组
 * 计数排序的场景：计数排序只能用在数据范围不大的场景中，
 * 如果数据范围K 比要排序的数据n 大很多， 就不适合用计数排序了。而且，计数排序只能给非负整数排序，
 * 如果要排序的数据是其他类型的，要将其在不改变相对大小的情况下，转化为非负整数。
 *
 * @author nancy.wang
 * @Time 2019/2/1
 */
public class CountSort {

    public static void countingSort(int[] a, int n) {
        if (n <= 1) return;
        //扫描数组，获取数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        //申请数组C
        int[] c = new int[max + 1];

        //计算每个元素的个数，放入C中
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        //重置c[i]的到定义， c[i]存储的是小于等于k的考生个数
        for (int i = 1; i < max + 1; i++) {
            c[i] = c[i - 1] + c[i];
        }

        //计数排序，填充r 数组
        int[] r = new int[n];
        //这里从A 数组 从尾到头开始遍历，为了保证 是 稳定排序。
        //为什么会出现不稳定排序：如果从A 开始遍历， 有两个相同的数字，首次出现的可能排在后面，
        //这就出现了不稳定的情况
        for(int i= n-1; i >=0; i--){
            int index=c[a[i]] - 1;
            r[index] =a[i];
            c[a[i]]--;
        }

        //将结果拷贝回A 数组
        for(int i=0; i<n; i++){
            a[i] = r[i];
        }

    }

    public static void main(String[] str){
        int[] array = {2,5,3,0,2,3,0,3};
        countingSort(array, array.length);
        Arrays.stream(array).forEach(System.out::println);
    }


}
