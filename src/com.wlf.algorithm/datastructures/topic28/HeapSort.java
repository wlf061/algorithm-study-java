package com.wlf.algorithm.datastructures.topic28;

/***
 * 堆满足的条件:
 * 1. 堆是一个完全二叉树
 * 2. 堆中的每一个节点的值都必须大于等于其子树中每个节点的值
 * 3. 数组中下标为i的节点的左子节点，就是下标为i*2 的节点，右子节点就是下标为i*2+1 的节点，
 * 父节点就是下标为i/2的节点
 * @author nancy
 */
public class HeapSort {
    private int[] a; // 数组，从下标1开始存储数据
    private int n; //堆可以存储的最大数据个数
    private int count; //堆中已经存储的数据个数

    public HeapSort(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void swap(int[] a, int currentIndex, int maxPos) {
        int tmp = a[currentIndex];
        a[currentIndex] = a[maxPos];
        a[maxPos] = tmp;
    }

    // 建堆方法1: 堆插入数据需要堆化，　从　下而上的　堆化
    public void insert(int data) {
        if (count >= n) return; //堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
        }
    }

    /**
     * 建堆方法2:相对于第一种方法， 这里假设数组里面 已经是满容量数据，然后叶子节点不堆化
     * 只堆化根节点
     */
    public void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    /***
     * 删除堆顶元素，删除堆顶元素之后
     * 需要把第二大的元素放到堆顶，然后再迭代的删除第二大节点， ，以此类推，直到叶子节点
     * 被删除。
     * 容易出现的问题：最终堆化出来的堆并不满足完全二叉树
     *
     * 解决方法：将最后一个节点放到堆顶， 然后利用同样的父子节点对比方法，　从上而下的堆化
     */

    public void removeMax() {
        if (count == 0) return; // 堆中没有数据
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int n, int i) { //自上往下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }

    }

    /***
     * 类似删除操作，先将堆顶的元素和第n个元素交换位置，然后对[1....n-1] 进行堆化，再取出堆顶元素和n-1 交换，以此类推
     * @param a
     * @param n
     */
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            k--;
            heapify(a, k, 1);
        }
    }

    public static void main(String[] str) {
        int[] a = {1, 4, 6,5,3,2,10};
        new HeapSort(30).sort(a, 6);
        for (int index = 0; index < a.length; index++) {
            System.out.println(a[index]);
        }

    }


}
