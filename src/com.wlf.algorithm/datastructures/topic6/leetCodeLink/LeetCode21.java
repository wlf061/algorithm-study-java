package com.wlf.algorithm.datastructures.topic6.leetCodeLink;

/**
 * 合并两个排序列表
 *
 * @author nancy.wang
 * @Time 2019/1/18
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode r = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                r.next = l1;
                l1 = l1.next;
            } else {
                r.next = l2;
                l2 = l2.next;
            }
            r = r.next;
        }
        if (l1 == null) {
            r.next = l2;
        } else {
            r.next = l1;
        }

        return head;
    }

    public static void printAll(ListNode testNode) {
        while (testNode != null) {
            System.out.print(testNode.val + ",");
            testNode = testNode.next;
        }
        System.out.println();
    }

    public static void main(String[] str) {
        ListNode[] nodeArray = new ListNode[3];
        nodeArray[0] = new ListNode(1);
        nodeArray[1] = new ListNode(2);
        nodeArray[2] = new ListNode(3);
        nodeArray[0].next = nodeArray[1];
        nodeArray[1].next = nodeArray[2];


        ListNode[] nodeArray2 = new ListNode[2];
        nodeArray2[0] = new ListNode(1);

        //nodeArray[3].next = nodeArray[1];
        printAll(new LeetCode21().mergeTwoLists(nodeArray[0], nodeArray2[0]));

    }

}
