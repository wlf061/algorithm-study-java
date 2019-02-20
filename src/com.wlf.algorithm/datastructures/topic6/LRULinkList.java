package com.wlf.algorithm.datastructures.topic6;

import java.util.Scanner;

/**
 * LRU(Least Recently used) 最近最少使用策略;
 * 链表头为最近访问的，链表尾部为未访问的。
 * LRU 算法：
 * 1.下次遍历的时候，在链表中查找，如果找到了，将该几点删除，并放到链表头部
 * 2. 如果没在链表中，分两种情况：
 *   2.1 如果链表空间足够，插入到链表头
 *   2.2 如果链表空间不够，删除链表尾部元素，将元素插入链表头部
 *
 * @author nancy.wang
 * @Time 2019/1/14
 */
public class LRULinkList<T> {
    /***
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    private Node<T> head;

    private Integer length;
    private Integer capacity;

    //head 指针预留一个空闲操作，从next 开始遍历
    public LRULinkList() {
        this.head = new Node<T>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRULinkList(Integer capacity) {
        this.head = new Node<T>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T e) {
        Node preNode = findPreNode(e);
        //将当前的node 删除， 再把这个node 移到链表头部
        if (preNode != null) {
            //删除当前节点，并将e 挂到链表头部。
            intsertElemAtBegin(e);
            deleteElemOptim(preNode);
        } else { //preNode为空，当前链表中找不到 这个元素， 直接插在链表头，同时删除 尾部的元素。
            if (length >= this.capacity) {
                //删除尾结点
                deleteElemAtEnd();
            }
            intsertElemAtBegin(e);
        }
    }


    /*查找当前节点的前一个节点*/
    private Node findPreNode(T data) {
        Node tmpNode = head;
        while (tmpNode.getNext() != null) {
            if (tmpNode.getNext().getItem().equals(data)) {
                return tmpNode;
            } else {
                tmpNode = tmpNode.getNext();
            }
        }
        return null;
    }

    /**
     * 链表头部插入节点
     *
     * @param data
     */
    private void intsertElemAtBegin(T data) {
        Node next = head.getNext();
        head.setNext(new Node(data, next));
        length++;
    }

    //删除前一个节点下一个节点
    private boolean deleteElemOptim(Node<T> preNode) {
        if (preNode == null) {
            return false;
        }
        Node node = preNode.getNext();
        if (node.getNext() == null) { //尾节点
            node.setNext(null);
        } else {
            preNode.setNext(node.getNext());
        }
        node = null;
        length--;
        return true;
    }

    //删除尾部节点
    private void deleteElemAtEnd() {
        Node ptr = head;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }

        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        Node tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }


    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T item) {
            this.item = item;
        }

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private void printAll() {
        Node node = head.getNext();
        while (node != null) {
            System.out.print(node.getItem() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] str) {
        LRULinkList list = new LRULinkList<Integer>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
