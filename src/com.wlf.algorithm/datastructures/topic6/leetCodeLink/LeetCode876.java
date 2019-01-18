package com.wlf.algorithm.datastructures.topic6.leetCodeLink;

/**
 * 获取链表的中间节点
 *
 * @author nancy.wang
 * @Time 2019/1/18
 */
public class LeetCode876 {
    public static ListNode getMiddleListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            return slow;
        } else if(fast.next == null) {
            return slow.next;
        }
        return null;
    }

    public static ListNode getMiddleListNode2(ListNode head){
        //System.out.println(System.currentTimeMillis());
        Long startTime = System.currentTimeMillis();
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(System.currentTimeMillis() - startTime);
        return slow;
    }

    public static void printAll(ListNode testNode) {
        while (testNode != null) {
            System.out.print(testNode.val + ",");
            testNode = testNode.next;
        }
        System.out.println();
    }

    public static void main(String[] str) {
        ListNode[] nodeArray = new ListNode[4];
        nodeArray[0] = new ListNode(1);
        nodeArray[1] = new ListNode(2);
        nodeArray[2] = new ListNode(3);
        nodeArray[3] = new ListNode(4);
        nodeArray[0].next = nodeArray[1];
        nodeArray[1].next = nodeArray[2];
        nodeArray[2].next = nodeArray[3];


        //nodeArray[3].next = nodeArray[1];
        printAll(getMiddleListNode2(nodeArray[0]));
    }
}
