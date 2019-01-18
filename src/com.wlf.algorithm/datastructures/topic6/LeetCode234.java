package com.wlf.algorithm.datastructures.topic6;

/**
 * 判断字符串是否为回文：
 * 解题思路： 这里使用链表
 * 1. 定义 slow 和fast 两个 指针。 每次 循环 slow 移动1步， fast 移动两部。
 * 2. 在 slow 到达中点， fast 到达end, 开始翻转 slow 到 fast 的内容。
 * 3. 重新遍历 前半部分和 翻转过的指针内容是否相等。
 *
 * @author nancy.wang
 * @Time 2019/1/14
 */
public class LeetCode234 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) { // 奇数时需要处理
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void printAll(ListNode testNode) {
        while (testNode != null) {
            System.out.print(testNode.val + ",");
            testNode = testNode.next;
        }
        System.out.println();
    }

    public static void main(String[] str) {
        ListNode testNode = new ListNode(1);
        testNode.next = new ListNode(2);
        printAll(testNode);
        System.out.println(new LeetCode234().isPalindrome(testNode));
    }


}
