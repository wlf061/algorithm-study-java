package com.wlf.algorithm.datastructures.topic11;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;

/**
 * 使用fork/join 框架 实现快排
 *
 * @author nancy.wang
 * @Time 2019/1/29
 */
public class ForkJoinQuickSort extends RecursiveAction{
    private int[] array;
    private int left;
    private int right;


    public ForkJoinQuickSort(int[] array, int left, int right)
    {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        int pivot = partition(array, left, right);
        ForkJoinQuickSort task1 = null;
        ForkJoinQuickSort task2 = null;
        if (pivot - left > 1) {
            task1 = new ForkJoinQuickSort(array, left, pivot-1);
            task1.fork();
        }
        if (right - pivot > 1) {
            task2 = new ForkJoinQuickSort(array, pivot+1, right);
            task2.fork();
        }
        if (task1 != null && !task1.isDone()) {
            task1.join();
        }
        if (task2 != null && !task2.isDone()) {
            task2.join();
        }
    }

    public static int partition(int[] a, int left,int right){
        int pivot = a[right];
        int i=left;
        for(int j =left; j < right; ++j){
            if(a[j] < pivot){
                if(i == j){
                    i++;
                } else{
                    int tmp =a[i];
                    a[i++]=a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp =a[i];
        a[i] = a[right];
        a[right] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] a = {11,8,3,9,7,1,2,5};
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinQuickSort task = new ForkJoinQuickSort(a, 0, a.length-1);
        Future<Void> result = forkJoinPool.submit(task);
        try {
            result.get();
            for (int n : a) {
                System.out.print(n + " ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
