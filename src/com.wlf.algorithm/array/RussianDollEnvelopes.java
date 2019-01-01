package com.wlf.algorithm.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 俄罗斯沙皇问题
 * 使用O(N* log(N))算法， 算法原型即为LongestSubsequence2 中的 getdp2 算法。
 */
public class RussianDollEnvelopes {
    /** 二元组 */
    public static class Dot {
        int a, b;

        public Dot(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    /*** 比较器 */
    public static class DotComparator implements Comparator<Dot> {
        @Override
        public int compare(Dot o1, Dot o2) {
            if (o1.a == o2.a) {
                return o2.b - o1.b;// 这里按b从大到小排序
            } else {
                return o1.a - o2.a;
            }
        }
    }

    /** 开始查找 */
    public int maxEnvelops(int[][] es) {

        Dot[] dots = new Dot[es.length];
        for (int i = 0; i < es.length; i++) {
            dots[i] = new Dot(es[i][0], es[i][1]);
        }
        Arrays.sort(dots, new DotComparator());
        int[] h = new int[es.length];
        h[0] = dots[0].b;
        int hl = 0;// h中数据个数
        int r = 0;
        int l = 0;
        int mid = 0;
        for (int i = 1; i < dots.length; i++) {
            r = hl;
            l = 0;
            while (l <= r) {
                mid = (l + r) / 2;
                if (h[mid] < dots[i].b) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            hl = Math.max(hl, l);
            h[l] = dots[i].b;
        }
        return hl + 1;
    }

	public static void main(String[] args) {
		int es[][] = { { 4, 5 }, { 4, 6 }, { 6, 7 }, { 2, 3 }, { 1, 1 } };
		System.out.println(new RussianDollEnvelopes().maxEnvelops(es));
	}
}
