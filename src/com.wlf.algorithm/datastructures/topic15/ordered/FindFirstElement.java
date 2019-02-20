package com.wlf.algorithm.datastructures.topic15.ordered;

/**
 * 查找第一个值等于给定值的元素
 *
 * @author nancy.wang
 * @Time 2019/2/12
 */
public class FindFirstElement {
    public static int bsearch(int[] a, int n, int value){
        int low=0;
        int high = n-1;
        while(low <= high){
            //如果low 和high 比较大，直接用(hight+low)/2 容易溢出, 改进的方法是将
            //mid 的计算方法 写成 low+(high-low)/2,性能优化到极致，就是 low + (high-low) >> 1
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value){
                high = mid -1;
            } else if(a[mid] < value){
                low = mid + 1;
            } else{
                //假定当前的数组的递增有序的
                //如果当前元素等于value,遍历 index 之前的元素
                //看是否存在等于value 的
                if((mid == 0) || a[mid -1] != value) return mid;
                else high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] str){
        int[] nums = new int[] {1, 3, 3, 3, 3, 6, 7, 9, 12, 14, 18};
        System.out.println(bsearch(nums, nums.length, 18));

    }
}
