package com.wlf.algorithm.datastructures.topic6.leetCodeLink;

/**
 * 删除链表倒数第 n 个结点
 *
 * @author nancy.wang
 * @Time 2019/1/18
 */
public class LeetCode19 {

    public ListNode deleteNnode(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode r = head;
        int length = 0;
        while (r != null) {
            length++;
            r = r.next;
        }
        ListNode scan = new ListNode(0);
        scan.next = head;
        head = scan;
        for (int index = 0; index < length - n; index++) {
            scan = scan.next;
        }

        scan.next = scan.next.next;
        return head.next;
    }


    /***
     * 使用双指针解决：先让fast指针移动n步，然后slow指针从链表头开始移动，
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode deleteNode2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        for (int index = 0; index < n; index++) {
            first = first.next;
        }
        ListNode slow = head;
        if (first == null) {
            return slow.next;
        }
        while (first.next != null) {
            first = first.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
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
        printAll(new LeetCode19().deleteNode2(nodeArray[0], 1));

    }
}
