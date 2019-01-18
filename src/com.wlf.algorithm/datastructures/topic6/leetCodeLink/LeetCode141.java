package com.wlf.algorithm.datastructures.topic6.leetCodeLink;
/**
 *  判断链表上是否有环:
 *  1.使用快慢指针，如果有环，快慢指针能相遇
 * @author nancy.wang
 * @Time 2019/1/17
 */
public class LeetCode141{
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            if(slow != fast){
                fast = fast.next.next;
                slow = slow.next;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] str){
        ListNode[] nodeArray = new ListNode[4];
        nodeArray[0] = new ListNode(3);
        nodeArray[1] = new ListNode(2);
        nodeArray[2] = new ListNode(0);
        nodeArray[3] = new ListNode(-4);
        nodeArray[0].next = nodeArray[1];
        nodeArray[1].next = nodeArray[2];
        nodeArray[2].next = nodeArray[3];

        nodeArray[3].next = nodeArray[1];
        System.out.println(new LeetCode141().hasCycle(nodeArray[0]));

    }
}


