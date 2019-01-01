package com.wlf.algorithm.array;

/**
 * 求数组的最长子序列（O（N*log(N)）的实现方法）,
 * 在生成dp 的时候使用O(N* log(N))算法
 */
public class LongestSubsequence2 {

    /***
     * 1. 增加辅助数组 ends[b]和right 变量。
     * 2. ends[b] 表示 长度为b+1 的递增子序列的最小结尾数是ends[b]; ends[0....right].ends 一定为
     * 一个递增数组
     * 为有效去，ends[right+1,....N-1]为无效区。
     * 3. 遍历（ends 为递增，可以使用二分查找）：
     *     3.1 在遍历arr[i]的过程中，查找ends[0,...right-1],存在比arr[i]大的则可以用arr[i]替换掉。
     *     3.2 如果ends 中 都比 arr[i] 小，则有效区间 右移
     */
    public int[] getdp2(int[] arr){
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        int right = 0;
        int l =0;
        int r =0;
        int m=0;
        // 二分查找 比arr[i] 大的数,ends 为递增数组。
        for(int i=1; i < arr.length; i++){
            l=0;
            r=right;
            while(l <= r){
                m=(l+r)/2;
                if(arr[i] > ends[m]){
                    l= m+1;
                }else{
                    //找到第一个大于arr[i]的值
                    r= m-1;
                }
            }
            right = Math.max(right,l);
            ends[l] = arr[i];
            dp[i] = l+1;
        }
        return dp;
    }

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
        int[] dp = getdp2(arr);
        return generateLIS(arr, dp);
    }

    public static void main(String[] str){
        int[] arr={2,1,5,3,6,4,8,9,7};
        int[] result = new LongestSubsequence1().list1(arr);
        for(int value: result){
            System.out.println(value);
        }
    }

}
