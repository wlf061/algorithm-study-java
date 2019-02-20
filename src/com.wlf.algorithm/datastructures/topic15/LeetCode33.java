package com.wlf.algorithm.datastructures.topic15;

/**
 * 使用O(logn), 旋转后的数组是部分 有序的
 *
 *定义三个指针low, mid, high, 如果首元素小于 mid，说明前半部分[low,...,mid]是有序的；
 证明下这种情况：假设数组旋转后的组成为array=[A1，B1]，A1和B1分别递增
 可能存在三种情况：
 [low,...., mid] 区间中只包含A1 的元素，此时这个区间是递增有序的
 [low,...., mid] 区间中只包含B1 的元素， 此时也是递增有序的
 [low,...., mid] 区间中包含一部分A1 和一部分B1，此时不可能出现array[low] < array[mid], 因为A1 中的元素一定大于B1中的元素。
 所以当array[low] < array[mid] array[low,....,mid]一定是有序的
 *
 * @author nancy.wang
 * @Time 2019/2/12
 */
public class LeetCode33 {

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target)
                return mid;
            if (nums[mid] <= nums[low]) { //右半部分有序
                if (target > nums[mid] && target < nums[high]) {
                    low = mid + 1;
                } else if (target == nums[high]) {
                    return high;
                } else {
                    high = mid - 1;
                }
            } else { //左半部分有序
                if (target < nums[mid] && target > nums[low]) {
                    high = mid - 1;
                } else if (target == nums[low]) {
                    return low;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] str) {
        int[] array = {6, 7, 0, 1, 2, 3, 4, 5};
        System.out.println(search(array, 0));
    }

}
