package com.wlf.algorithm.DoublePointer;

/**
 * 类似 leetCode42 双向指针的问题
 *
 * @author nancy.wang
 * @Time 2019/1/3
 */
public class LeetCode11 {

    /****
     * 1. 两个指针left 和right, 分别向中间移动。area = Math.min(arr[left], arr[right]) * (right - left)
     * 2. 如果 arr[left] > arr[right], 那么 right 向左移动, 否则 left 向右移动。
     * （为什么需要较小的移动？ 因为1 中的面积为arr[left], arr[right]较小者乘以宽度，此时 较小者为瓶颈， 移动最小者：
     * 举例：arr[left] = 6, arr[right] = 7, right-left=10, 此时面积为60
     * 如果 此时移动right, 会出现两种情况
     * 1. arr[right-1] > 6, 此时面积为 6*9 < 60
     * 2. arr[right - 1] < 6, 此时面积为 arr[right-1] * 9 < 60
     * <p>
     * 所以移动较小者 才有可能获取到更大的面积。）
     */
    public int getMaxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left <= right) {
            //            max = Math.max(max, (right-left)*Math.min(height[left], height[right])); 耗时 9ms, 用下面的耗时7ms
            if (height[left] < height[right]) {
                int cur = height[left] * (right - left);
                max = max > cur ? max : cur;
                left++;
            } else {
                int cur = height[right] * (right - left);
                max = max > cur ? max : cur;
                right--;
            }
        }
        return max;
    }

    public static void main(String[] str) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new LeetCode11().getMaxArea(arr));
    }
}
