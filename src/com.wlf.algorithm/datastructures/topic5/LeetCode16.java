package com.wlf.algorithm.datastructures.topic5;

import java.util.Arrays;

/**
 * Majority Element(求众数)
 *
 * @author nancy.wang
 * @Time 2019/2/18
 */
public class LeetCode16 {
    public int majorityElement(int[] nums) {

        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;

        }
        return major;
    }

    public int majorityElement2(int[] nums){
        Arrays.sort(nums);
        int candidate = nums[nums.length/2];
        int count=0;
        for(int index=0; index < nums.length;index++){
            if(nums[index] == candidate){
                count++;
            }
        }
        return count > nums.length /2 ? candidate: -1;
    }

    public static void main(String[] str) {
        int[] array = {-1,1,1,1,2,1};  //[-1,1,1,1,2,1]
        System.out.println(new LeetCode16().majorityElement2(array));
    }
}
