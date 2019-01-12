package com.wlf.algorithm.niukewang.chapter1.DoublePointer;

/**
 * Refer:https://www.cnblogs.com/fisherinbox/p/5715017.html
 * 给定一个非负数的数组，代表一个容器。
 * 例如数组[0,1,0,2,1,0,1,3,2,1,2,1]，就是以下图形中黑色的部分。
 * 如果用这个容器接水的话，请问可以接多少水？还以这个数组为例，可以接6格水
 *
 *
 * 简化题意：如果能求得当前位置格子上的水量，那么总水量就是每个位置水量之和。
 * 当前格子上所能存储的水量 = 当前格子左边最大值与右边最大值之间的较小值 - 当前格子高度
 */
public class Leetcode42 {

    /***
     * 时间复杂度O(N)， 空间复杂度O(N)的算法。
     *  1.先求出当前格子左边的最大值与右边最大值，对于右边最大值用数组r来辅助存储，从右往左遍历一下原数组即可得到r
     *  2. 对于左边的最大值在遍历原数组的同时用一个全局变量记录下来就行，此时时间复杂度为O(n) 空间复杂度O(n)
     */
     public int getWeight(int[] height){
         if(height == null || height.length <=3){
             return 0;
         }
         int n = height.length -2;
         int[] rightMax = new int[n];
         rightMax[n- 1]= height[n+1];
         int totalValue =0;

         for(int index= n - 2; index >=0; index--){
             rightMax[index] =Math.max(height[index +2],rightMax[index+1]);
         }
         int leftMax=height[0];
         for(int index =1; index <= n; index++){
             totalValue+=Math.max(0, Math.min(leftMax, rightMax[index-1]) - height[index]);
             leftMax = Math.max(leftMax, height[index]); //下一次遍历时 的最大leftMax
         }
         return totalValue;
     }

    public static void main(String[] args){
        Leetcode42 q = new Leetcode42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(q.getWeight(height));
    }
}
