package com.wlf.algorithm.datastructures.topic9;

/**
 * 基于数组实现的动态链表;
 * 这里的实现 链表tail 指向下一个空闲元素的index,最大值为容量 n。
 *
 * @author nancy.wang
 * @Time 2019/1/18
 */
public class DynamicArrayQueue {
    //数组： items, 数组大小：n
    private String[] items;
    private int n = 0;
    // head 表示队头下标， tail 表示队尾下标
    private int head = 0, tail = 0;

    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public String dequeue() {
        //如果head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        String ret = items[head++];
        return ret;
    }

    /****
     * 在出队列的时候，每次删除一个元素的时间复杂度都是O（n）, 如何进行优化呢？
     * 可以使用类似先标记,后整块清除的算法，这样 有些内存空间可重复利用。使用整块数据移动。
     * 均摊时间复杂度 为O（1）
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        if (tail == n) {
            //tail == n && head == 0 表示整个队列都占满了
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail++] = item;  //tail 多占用一个单元。
        return true;
    }

}
