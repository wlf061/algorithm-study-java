package com.wlf.algorithm.niukewang.Chapter3;

/**
 * 牛课堂算法精讲直播讲座（2016） > 第三章 > 牛课堂第三章 第四题(完全二叉树)
 *
 * @author nancy.wang
 * @Time 2019/1/16
 */
public class BinaryTree {

    static class Node {
        private Node leftNode;
        private Node rightNode;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /***
     * 完全二叉树：给定一颗完全二叉树的头结点head, 求其中的节点个数， 时间复杂度O（logN * logN）
     */
    public static int nodeNums(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /***
     * @param node
     * @param l    表示当前遍历的层数;
     *             1.先计算出二叉树的高度h， 记录传入的遍历的当前层数l
     *             2. 然后计算右节点的左子树的高度，看是否等于h,不等
     *                2.1 如果等于h, 则表示左节点的是一颗满二叉树，可以计算高度，h-l,
     *             当前节点数为 1 << (h-l) - 1, 再加上一个节点，为 1 << (h-l) -1 +1.
     *               2.2 如果不等于h, 则右子树的层数是 h-l -1 , 且是满二叉树， 可以计算节点数 1 << (h - l - 1)， 递归 左子树
     *
     * @param h
     * @return
     */
    public static int bs(Node node, int l, int h) {
        if (l == h) {
            return 1;
        }
        if (mostLeftLevel(node.rightNode, l + 1) == h) {
            return (1 << (h - l)) + bs(node.rightNode, l + 1, h);
        } else {
            return (1 << (h - l - 1)) + bs(node.leftNode, l + 1, h);
        }
    }

    //获取树的深度
    public static int mostLeftLevel(Node headNode, int level) {
        while (headNode != null) {
            level++;
            headNode = headNode.leftNode;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.leftNode = new Node(2);
        head.rightNode = new Node(3);
        head.leftNode.leftNode = new Node(4);
        head.leftNode.rightNode = new Node(5);
        //System.out.println(nodeNums(head));

        System.out.println(head);
        mostLeftLevel(head,1);
        System.out.println(head);

    }
}
