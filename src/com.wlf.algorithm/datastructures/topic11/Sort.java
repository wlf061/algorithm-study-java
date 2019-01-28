package com.wlf.algorithm.datastructures.topic11;

public class Sort {


    /**
     * 冒泡排序:原地排序，空间复杂度为O(1)，稳定的排序，时间复杂度为O(N * N)
     * <p>
     * 引入 "有序度" 和 "逆序度" 来计算 平均时间复杂度：
     * 逆序度 = 满有序度 - 有序度。我们排序的过程就是一种增加有序度，减少逆序度的过程，最后达到满有序度，说明排序完成
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < a.length; i++) {
            //提前退出的标志， 如果某一趟冒泡，没有任何交换， 则提前退出。
            boolean isSwap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    isSwap = true;
                }
            }
            if(isSwap == false){
                return;
            }
        }

    }

    /****
     * 插入排序：数据移动的次数 = 满有序度（n*(n-1)/2）- 初始有序度
     * 插入排序：分为已排序区间和未排序区间，插入算法的核心思想是取未排序区间中的元素，
     *          在已排序区间中找到合适的插入位置插入，并保证已排序区间的数据一致有序
     * @param a
     * @param n
     */
    public static void insertSort(int[]a, int n){
        if(n <= 1) return;
        for(int i=0; i < a.length; i++){
            int value = a[i];
            int j=i-1;
            for(; j >=0; j--){
                if(a[j] > value){
                    a[j+1] = a[j];
                }
                else{
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    /***
     * 选择排序算法的实现思路和插入排序类似，也分已排序区间和未排序区间。但是选择排序每次会从
     * 未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     * @param a
     * @param n
     */
    public static void selectSort(int[]a,int n){
        if(n <= 1) return;
        for(int i=0; i < a.length -1; i++){
            int minIndex=i;
            for(int j=i+1; j < a.length; j++){
                if(a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            //交换
            int value =a[i];
            a[i] = a[minIndex];
            a[minIndex] = value;
        }

    }

}
