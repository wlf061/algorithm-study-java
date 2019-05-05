package com.wlf.algorithm.datastructures.topic38;


/***
 * 使用归并算法来计算给定数组的逆序度。
 * 逆序度：A[6] = {2,4,3,1,5,6}, 逆序度数组为（2，1）， （3，1），（4，3），（4，1）
 */
public class CountReverseOrder {
    private int num = 0;

    public int count(int[] a, int n){
        num =0;
        mergeSortCounting(a, 0, n-1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p ,int r){
        if(p >= r) return;
        int q = p + (r-p)/2;
        mergeSortCounting(a,p,q);
        mergeSortCounting(a,q+1, r);
        merge(a,p,q,r);

    }
    private void merge(int[] a, int p, int q, int r){
        int i = p, j = q+1, k = 0;
        int[] tmp = new int[r-p+1];
        while(i <= q && j <= r){
            if(a[i] <= a[j]){
                tmp[k++] = a[i++];
            } else{
                num += (q-i+1);  //经过一步步归并，a 中的数组已经是排序的，所以 当a[i] > a[j] 时， a[i+1.....p] 都大于a[j], 这里计算p~q 中所有大于a[j]的元素个数
                tmp[k++] =  a[j++];
            }
        }
        while(i <=q){
            tmp[k++] = a[i++];
        }

        while(j <= r){
            tmp[k++] =  a[j++];
        }
        for(int index=0; index <= r-p; index++){
            a[p+index] = tmp[index];
        }
    }

    public static void main(String[] str){
        int[] a = {2,4,3,1,5,6};
        System.out.println(new CountReverseOrder().count(a,6));
    }
}
