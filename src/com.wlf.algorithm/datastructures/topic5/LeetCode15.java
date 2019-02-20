package com.wlf.algorithm.datastructures.topic5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3sum问题，三元组合为0, 且三元组不重复
 * 针对有序数组，使用双指针
 *
 * @author nancy.wang
 * @Time 2019/2/15
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, n = nums.length;
        int first = i + 1, last = n - 1;
        int target = 0;
        while (i < n - 2) {
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                i++;
                continue;
            }
            first = i + 1;
            last = n - 1;
            target = -nums[i];
            while (first < last) {
                if (nums[first] + nums[last] == target) {
                    res.add(Arrays.asList(nums[i], nums[first], nums[last]));
                    //因为不能有重复的元素。所以nums[first]，nums[last] 都必须不同于之前的
                    first++;
                    last--;
                    while ((first < last) && (nums[first] == nums[first - 1])) first++;
                    while ((first < last) && (nums[last] == nums[last + 1])) last--;

                } else if (nums[first] + nums[last] > target) {
                    last--;
                } else {
                    first++;
                }
            }
            i++;
        }
        return res;
    }

    public static void main(String[] str) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //int[] nums = {-2, 0, 1, 1, 2};
        List<List<Integer>> result = new LeetCode15().threeSum(nums);
        for (int index = 0; index < result.size(); index++) {
            for (int k = 0; k < result.get(index).size(); k++) {
                System.out.print(result.get(index).get(k) + ",");
            }
            System.out.println();
        }
    }
}
