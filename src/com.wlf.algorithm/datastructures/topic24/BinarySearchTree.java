package com.wlf.algorithm.datastructures.topic24;

/**
 * 二叉查找树：二叉查找树要求，树种的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，
 * 而右子树节点的值都大于这个节点的值
 *
 * @author nancy.wang
 * @Time 2019/2/20
 */
public class BinarySearchTree {
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    //查找某个元素
    public Node find(int data) {
        Node p = head;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }

    public void insert(int data) {
        Node p = head;
        if (head == null) {
            head = new Node(data);
            return;
        }
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }

    }

    public void delete(int value) {
        Node p = head;
        Node pp = null;
        while (p != null && p.data != value) {
            pp = p;
            if (value > p.data) p = p.right;
            else p = p.left;
        }
        //没有找到节点
        if (p == null) return;

        //要删除的节点有两个子节点，这个时候找到右子树中最小的节点, 替换当前的节点，删除最小的节点
        if (p.right != null && p.left != null) {
            Node minP = p.right;
            Node minPP = p; //表示minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data; //将minP的数据替换到p中
            //剩下的为删除 minp 节点，重用下面的流程，只需要更新p和PP 即可，不能简单的置为null
            p = minP;
            pp = minPP;
        }

        //删除节点是叶子节点或者只有一个子节点
        Node child; //p 的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;


        if (pp == null) head = child; // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }

    //实现中序遍历
    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print("\t" + node.data);
        inOrder(node.right);
    }

    public static void main(String[] str) {
        int[] testArray = {33, 16, 50, 13, 18, 34, 58, 15, 17, 25, 51, 66, 19, 27, 55};
        BinarySearchTree searchTree = new BinarySearchTree();
        for (int index = 0; index < testArray.length; index++) {
            searchTree.insert(testArray[index]);
        }
        searchTree.delete(27);
        searchTree.inOrder(searchTree.getHead());
    }


}
