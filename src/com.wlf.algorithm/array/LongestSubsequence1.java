package com.wlf.algorithm.array;

/**
 * 求数组的最长子序列（O（N*N）的实现方法）
 */
public class LongestSubsequence1 {


    /*
    * 获取dp[i]: 表示以arr[i]这个数结尾的情况下， 最长递增子序列的长度
    * */
    public int[] getdp1(int[]arr){
        int[] dp = new int[arr.length];
        for(int i=0; i < arr.length; i++){
            dp[i] = 1;
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j])
                {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }

    /*
    * 结合dp 和arr 来求出 最长子序列，
    * 通过上面求解dp 的过程来获取子序列：
    * 1. 遍历dp数组，找到最大值及位置k.那么这个最长子序列是以arr[k]结尾。
    * 2. 如果对于某一个位置i， 既有 arr[i] < arr[k], 同时dp[i] == dp[k] -1, 说明arr[i]
    * 可以作为最长递增子序列的倒数第二个数， 一次内推。
    * */

    public int[] generateLIS(int[] arr, int[] dp){
        int len=0;
        int index=0;
        for(int i=0; i< dp.length; i++){
            if(dp[i] > len){
                len = dp[i];
                index=i;
            }
        }
        int[] list = new int[len];
        list[--len] = arr[index];
        for(int i=index; i>=0; i--){
            if(arr[i] < arr[index] && dp[i] == dp[index]-1)
            {
                list[--len] = arr[i];
                index=i;
            }
        }
        return list;
    }

    public int[]  list1(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        int[] dp = getdp1(arr);
        return generateLIS(arr, dp);
    }

    public static void main(String[] str){
        int[] arr={2,1,5,3,6,4,8,9,7};
        int[] result = new LongestSubsequence2().list1(arr);
        for(int value: result){
            System.out.println(value);
        }
    }
}
