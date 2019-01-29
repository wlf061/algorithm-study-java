package com.wlf.algorithm.datastructures.topic11;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 类的描述
 *
 * @author nancy.wang
 * @Time 2019/1/29
 */
public class ForkJoinMergeSort {
    private static int MAX  = 10000000;
    private static int inits[] = new int[MAX];
    static{
        Random r = new Random();
        for(int index=1; index <= MAX; index++){
            inits[index - 1] = r.nextInt(10000000);
        }
    }

    private static int[] joinInts(int array1[] , int array2[]) {
        int destInts[] = new int[array1.length + array2.length];
        int array1Len = array1.length;
        int array2Len = array2.length;
        int destLen = destInts.length;

        // 只需要以新的集合destInts的长度为标准，遍历一次即可
        for(int index = 0 , array1Index = 0 , array2Index = 0 ; index < destLen ; index++) {
            int value1 = array1Index >= array1Len?Integer.MAX_VALUE:array1[array1Index];
            int value2 = array2Index >= array2Len?Integer.MAX_VALUE:array2[array2Index];
            // 如果条件成立，说明应该取数组array1中的值
            if(value1 < value2) {
                array1Index++;
                destInts[index] = value1;
            }
            // 否则取数组array2中的值
            else {
                array2Index++;
                destInts[index] = value2;
            }
        }

        return destInts;
    }


    public static void main(String[] args){

        // 正式开始
        long beginTime = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        MyTask task = new MyTask(inits);
        ForkJoinTask<int[]> taskResult = pool.submit(task);
        try {
            taskResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(System.out);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时=" + (endTime - beginTime));

    }

    static class MyTask extends RecursiveTask<int[]>{

        private int source[];
        public MyTask(int source[]){
            this.source = source;
        }

        @Override
        protected int[] compute() {
            int sourceLen = source.length;
            if(sourceLen > 2){
                int midIndex = sourceLen/2;
                MyTask task1 = new MyTask(Arrays.copyOf(source, midIndex));
                task1.fork();
                MyTask task2 = new MyTask(Arrays.copyOfRange(source, midIndex, sourceLen));
                task2.fork();
                System.out.println("线程的名字："+Thread.currentThread().getName() + "，线程的 id："+Thread.currentThread().getId());
                //将两个有序的数组，合并成一个有序的数组
                int result1[] = task1.join();
                int result2[] = task2.join();
                int mer[] = joinInts(result1 , result2);
                return mer;
            }
            else{
                if(sourceLen == 1
                        || source[0] <= source[1]) {
                    return source;
                } else {
                    int targetp[] = new int[sourceLen];
                    targetp[0] = source[1];
                    targetp[1] = source[0];
                    return targetp;
                }

            }
        }
    }
}
