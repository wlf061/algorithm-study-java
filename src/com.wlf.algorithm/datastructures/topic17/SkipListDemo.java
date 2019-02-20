package com.wlf.algorithm.datastructures.topic17;

import java.util.Random;

/**
 * 注意点：1. 原始数据 在level 0
 * 2. 插入的数据 计算随机层： level = randomLevel, 在 0~level -1 中都需要插入该节点，避免跳表
 *
 * @author nancy.wang
 * @Time 2019/2/13
 */
public class SkipListDemo {
    private static final int MAX_LEVEL = 16;
    private Random r = new Random();
    private Node head = new Node();  // 初始化链表节点
    private int levelCount = 1;

    class Node {
        private int data = -1;
        private Node[] forwards = new Node[MAX_LEVEL];
        private int maxLevel = 0;


        @Override
        public String toString() {
            StringBuffer builder = new StringBuffer();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }

    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; i++) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        Node node = new Node();
        node.data = value;
        node.maxLevel = level; // 记录当前节点所在的最大一层

        Node update[] = new Node[level];

        for (int i = 0; i < level; ++i) {
            update[i] = head; //初始化
        }
        Node p = head;

        //记录每一层， 最后一个小于value的节点
        for (int index = level - 1; index >= 0; index--) {
            while (p.forwards[index] != null && p.forwards[index].data < value) {
                p = p.forwards[index];
            }
            update[index] = p;
        }

        // in search path node next node become new node forwords(next)
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // update node hight
        if (levelCount < level) levelCount = level;


    }

}
