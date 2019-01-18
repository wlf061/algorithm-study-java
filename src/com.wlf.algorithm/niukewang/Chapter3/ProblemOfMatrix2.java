package com.wlf.algorithm.niukewang.Chapter3;

import java.util.Stack;

/**
 * 牛课堂算法精讲直播讲座（2016） > 第三章 > 牛课堂第三章(第三题)
 *
 * @author nancy.wang
 * @Time 2019/1/8
 */
public class ProblemOfMatrix2 {

    /****
     * 题目3：给定一个无序矩阵，其中只有1和0两种值， 求只含有1 的最大的子矩阵大小， 矩阵的大小用其中的元素个数来表示
     * <p>
     * 1. 矩阵压缩， 计算出以每一行为底的直方图：
     * 举例： 矩阵为  0 1 1 0 1
     * 1 1 0 1 1
     * 以第一行为底的直方图为： 0 1 1 0 1
     * 以第二行为底的直方图为： 1 2 0 1 2  （当前底的数值为0，则直方图值为0）
     * 2. 对1中生成的直方图，采用入栈，出栈的方法来计算最大的矩阵大小。
     * 3.
     */
    public static int getMaxLengthOfMatrix(int[][] map) {
        if (null == map || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxLength = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            //计算好了以第i 行为底的直方图，开始对直方图入栈， 出栈。
            int currentLength = getMaxRecFromBottom(height);
            maxLength = Math.max(currentLength, maxLength);
        }
        return maxLength;
    }

    public static int getMaxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxLength = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int index = 0; index < height.length; index++) {
            while (!stack.isEmpty() && height[index] <= stack.peek()) {
                int currentIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = index;
                int currentLength = (rightIndex - leftIndex - 1) * height[currentIndex];
                maxLength = Math.max(maxLength, currentLength);
            }
            stack.push(index);
        }
        //在执行完height 后 栈里面如果还有元素也需要一个个pop出来计算高度
        while(!stack.isEmpty()){
            int currentIndex = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            int rightIndex = height.length;  // 注意此时 的rightIndex = height.length
            int curretArea = (rightIndex - leftIndex - 1) * height[currentIndex];
            maxLength = Math.max(maxLength, curretArea);
        }
        return maxLength;
    }


    public static void main(String[] str) {
        int[][] array = {{0, 1, 1, 1}, {0, 1, 1, 1}, {1, 1, 0, 1}};
        System.out.println(ProblemOfMatrix2.getMaxLengthOfMatrix(array));

    }
}
