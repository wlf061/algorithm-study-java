package com.wlf.algorithm.datastructures.topic8;

import java.util.Stack;

/**
 * Implement Queue using Stacks
 *  一个栈 入数据， 一个栈出数据
 *
 * @author nancy.wang
 * @Time 2019/1/21
 */
public class LeetCode232 {

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }

    public static void main(String[] str){
        LeetCode232 queue = new LeetCode232();
        queue.push(1);
        queue.push(2);
        queue.peek();  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
    }


}
