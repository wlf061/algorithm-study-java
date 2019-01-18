package com.wlf.algorithm.datastructures.topic6.leetCodeLink;

/**
 * 单链表的链表反转
 * @author nancy.wang
 * @Time 2019/1/17
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head){
         if(head == null){
             return null;
         }
        ListNode leftNode = null;
         while(head != null){
             ListNode rightNode = head.next;
             head.next = leftNode;
             leftNode = head;
             head = rightNode;
         }
        return leftNode;
    }

    public static void main(String[] str){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        ListNode reverseNode = new LeetCode206().reverseList(node);
        /*System.out.println(new LeetCode206().reverseList(node));*/
        while(reverseNode != null){
            System.out.print(reverseNode.val +"\t");
            reverseNode = reverseNode.next;
        }
    }

}
