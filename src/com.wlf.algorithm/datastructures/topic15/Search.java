package com.wlf.algorithm.datastructures.topic15;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * 查找算法
 *
 * @author nancy.wang
 * @Time 2019/2/1
 */
public class Search {

    public int bsearch(int[] a, int n, int value){
        int low=0;
        int high = n-1;
        while(low <= high){
            //如果low 和high 比较大，直接用(hight+low)/2 容易溢出, 改进的方法是将
            //mid 的计算方法 写成 low+(high-low)/2,性能优化到极致，就是 low + (high-low) >> 1
            int mid = low + (high - low) >> 1;
            if(a[mid] == value){
                return mid;
            } else if(a[mid] < value){
                low = mid + 1;
            } else{
                high = mid -1;
            }
        }
        return -1;
    }

    //递归方法实现的二分查找
    public int bsearchRecursive(int[] a, int n, int val){
            return bsearchInternally(a, 0, n-1, val);
    }

    private int bsearchInternally(int[] a, int low, int high,int value){
        if(low > high){
            return -1;
        }
        int mid = low + (high-low) >> 1;
        if(a[mid] == value){
            return mid;
        } else if(a[mid] < value){
            return bsearchInternally(a, mid+1, high,value);
        } else{
            return bsearchInternally(a, low, mid-1,value);
        }


    }

}
