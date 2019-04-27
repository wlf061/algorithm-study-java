package com.wlf.algorithm.datastructures.topic29;

import java.util.PriorityQueue;

/**
 * 计算出海量数据里的 top k 的数据，通过 最小堆来实现；
 *
 */
public class TopK {
    public static int[] topk(int[] data, int k){
        PriorityQueue<Integer>queue = new PriorityQueue<>(k);

        for(int i=0; i < data.length; i++){
            if(queue.size() < k){
                queue.offer(data[i]);
            } else {
                int value = queue.peek();
                if(data[i] > value){
                    queue.poll();
                    queue.offer(data[i]);
                }
            }
        }
        int[] result = new int[k];
        int index=0;
        while(!queue.isEmpty()){
            result[index++] = queue.poll();
        }
        return result;
    }
    public static void main(String[] str){
        int [] data = {2,3,4,5,6,2,15};
        int[] result = TopK.topk(data,3);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}
