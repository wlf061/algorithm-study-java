package com.wlf.algorithm.datastructures.topic8;

/**
 * LeetCode155 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * @author nancy.wang
 * @Time 2019/1/21
 */
public class MinStack {
    private Node head;

    private static class Node {
        int item;
        int min;
        Node next;

        Node(int item, int min) {
            this(item, min, null);
        }

        Node(int item, int min, Node next) {
            this.item = item;
            this.min = min;
            this.next = next;
        }
    }


    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head); //head 节点上保存最小的值
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.item;
    }

    public int getMin() {
        return head.min;
    }

    public static void main(String[] str){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.top();
        System.out.println(minStack.getMin());
    }
}
