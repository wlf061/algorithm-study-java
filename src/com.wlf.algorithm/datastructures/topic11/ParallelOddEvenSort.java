package com.wlf.algorithm.datastructures.topic11;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并行算法
 *
 * @author nancy.wang
 * @Time 2019/1/29
 */
public class ParallelOddEvenSort {
    static int[] array={1,4,5,2,3};
    static boolean swap;
    static ExecutorService es = Executors.newCachedThreadPool();
    public ParallelOddEvenSort(int[] a){
        array = a;
    }

    public static synchronized void setSwap(boolean s){
        swap =s;
    }

    public static synchronized boolean getSwap(){
        return swap;
    }

    public static class oddEvenSort implements  Runnable{
        int i;
        CountDownLatch latch;
        public oddEvenSort(int i, CountDownLatch latch){
            this.i =i;
            this.latch = latch;
        }

        @Override
        public void run() {
            if(array[i] > array[i + 1]) {
                int tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
                setSwap(true);
            }
            latch.countDown();
        }

        public static void main(String[] args) throws InterruptedException{
            setSwap(true);
            int start = 1;
            while (!(getSwap() == false && start == 1)) {
                setSwap(false);
                //每一趟交换的数量, 定义成CountDownLatch, 每次执行之后就进行countDown.
                CountDownLatch latch = new CountDownLatch((array.length - start) / 2);
                //或CountDownLatch latch = new CountDownLatch(array.length/2 -(array.length%2 == 0?start:0));
                for(int i = start; i < array.length - 1; i += 2) {
                    es.submit(new oddEvenSort(i, latch));
                }
                latch.await(); //等待所有的线程执行完成，然后进行下一趟冒泡
                if(start == 0) {
                    start = 1;
                } else {
                    start = 0;
                }
            }
            System.out.println(Arrays.toString(array));
            es.shutdown();
        }
    }

}
