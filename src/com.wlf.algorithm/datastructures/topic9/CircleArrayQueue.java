package com.wlf.algorithm.datastructures.topic9;

/**
 * 循环队列
 * DynamicArrayQueue 在数据移动时影响了数据的入队列速度。 使用循环队列可以 加快速度
 *  1.  队列 判空 条件 是 tail == head
 *  2.  队列判满条件 是 (tail+1)%n=head
 *  浪费一个存储空间，用来区分 满和空
 * @author nancy.wang
 * @Time 2019/1/18
 */
public class CircleArrayQueue {

    //数组： items, 数组大小：n
    private String[] items;
    private int n = 0;
    // head 表示队头下标， tail 表示队尾下标
    private int head = 0, tail = 0;

    public CircleArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public String dequeue() {
        // 如果head == tail 表示 队列为空
        if(head == tail){
            return null;
        }
        String ret = items[head];
        head = (head+1) % n;
        return ret;
    }

    public boolean enqueue(String item){
        if((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }
}
