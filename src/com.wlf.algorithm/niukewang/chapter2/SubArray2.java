package com.wlf.algorithm.niukewang.chapter2;

import java.util.HashMap;

/**
 * 牛课堂算法精讲直播讲座（2016） 左程云> 第二章 > 牛课堂第二章
 * https://www.nowcoder.com/live/11/2/1
 */
public class SubArray2 {

    /****
     * 未排序正数数组中累加和为给定值的最长子数组长度。第二题
     * 算法求解思路：
     * 1. 使用left 和right 指针。 right 遍历完数组。 这样就能找到 任何一个以 arr[i]结尾的子数组和 为k(如果存在的话)
     * 2. 如果 sum >= k, left++， sum -=array[left++]
     * 3. 如果 sum < k, right ++, sum += arrary[++right]
     * 4. 如果 sum == k, 计算 maxLength. sum -=array[left++]
     * @param array
     */
    public int getMaxLength(int[] array, int k) {
        if (array == null || array.length <= 0 || k == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int maxLength = 0, sum = array[0];
        while (right < array.length) {
            if (sum < k) {
                ++right;
                if (right == array.length) {
                    break;
                }
                sum += array[right];
            } else if (sum > k) {
                sum -= array[left++];
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
                sum -= array[left++];
            }
        }
        return maxLength;
    }

    /***
     * 未排序数组中累加和为给定值的最长子数组系列问题; 注意同getMaxLength 的区别，这里的数组可正，可负，可0
     * 解题思路：
     * 1. 因为 存在可正，可负，可0 的数， 所以不能向上一题的规则，指针移动
     * 2. 将题目转换思路：
     *    sum[i] = array[0]+.....+array[i];
     *    sum[j] = array[0]+.....+array[i]+array[i+1]+...+array[j] = sum[i]++array[i+!]+...+array[j]
     *    sum[i] + k = sum[j]
     *   只需要求出最早出现 sum[j] -k 的位置即可
     */
    public int getMaxLength2(int[] array, int k){
        if (array == null || array.length <= 0) {
            return 0;
        }
        //sumHashMap 的含义：key 为首次出现的sum， sum = array[0]+....+array[i], value 为 i.
        //如果后续还会出现sum, 不再更新; 只有当sum 不出现在sumHashMap 中时才插入
        HashMap<Integer, Integer> sumHashMap = new HashMap<Integer,Integer>();
        sumHashMap.put(0,-1); //初始化首次出现 sum =0. index = -1
        int sum =0;
        int maxLength =0 ;
        for(int i=0; i < array.length; i++){
            sum+= array[i];
            if(sumHashMap.containsKey(sum - k)){
                maxLength = Math.max(maxLength, i - sumHashMap.get(sum - k));
            }
            if(!sumHashMap.containsKey(sum)){
                sumHashMap.put(sum, i);
            }
        }
        return maxLength;
    }

    /***
     * 解题思路：
     * 4.未排序数组中累加和小于或等于给定值的最长子数组长度。
     *  解题思路 和 3 类似， 如果 用3 中的方法，算法复杂度 是O(n*n)，这里给出O（N* logN) 的算法
     *     1.同样转换成计算 sum[i] >= sum[j] - k, 那么 子数组 之和 array[i+1]+....+array[j] <= K
     *     2. 假设 sum[j] - k =3， 如果 首先出现 sum[i] == 5， 其次出现sum[i] ==  4, 其实 我们不关心 sum[i] ==  4
     *     的情况。
     *     3. 增加 一个辅助数据 h， h[i] 表示累加和数组中， 0到i 最大值。
     *      比如 数组 3 2 -3 2 -2 6 -3 1， h 则为： 3 5 5 5 5 8 8 8
     *     4. 通过二分查找，获取 h 中首次 出现 >= sum[j] -k 的下标 index, 既能计算出长度。
     * @param array
     * @param k
     * @return
     */
    public int getLessKMaxLength(int[] array, int k){
        if (array == null || array.length <= 0) {
            return 0;
        }
        int[] h = new int[array.length];
        h[0] = array[0];
        for(int index=1; index < array.length; index++){
            h[index]= Math.max(h[index-1]+array[index], h[index-1]);
        }
        int sum=0;
        int len =0;
        int res = 0;
        for(int i=0; i < array.length; i++){
            sum+= array[i];
            int pre = SubArray2.getLessIndex(h, sum-k, i);
            len = pre == -1 ? 0: i-pre+1;
            res = Math.max(res,len);
        }
        return res;
    }
    //这里的 index 入参 可以不用传入，因为 h为递增数组， 一定可以找到第一个最小的值，但是传入index 能减少遍历次数。
    private static int getLessIndex(int[] h, int sum, int index){
        int low=0, high= index;
        int mid = 0;
        int res = -1;
        while(low <= high){
            mid = (low+high) /2;
            if(h[mid] >= sum){
                res = mid;
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }
    public static void main(String[] str) {
        //测试 getMaxLength
        //int[] test1 = {1, 2, 1, 1, 1};
        //System.out.println(new SubArray2().getMaxLength(test1, 3));

        int[] test2={3,-2,-4,0,6};
        System.out.println(new SubArray2().getLessKMaxLength(test2,-2));
    }
}
