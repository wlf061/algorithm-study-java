package com.wlf.algorithm.datastructures.topic5;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by NJLT004 on 2019/1/13.
 */
public class GenericArray<T> {

    private T data[];
    private int size;

    public GenericArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }
    public GenericArray() {
        this(10);
    }
    public int getCapacity(){
        return data.length;
    }
    //获取当前元素个数
    public int count(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void set(int index, T e){
        checkIndex(index);
        data[index]=e;
    }

    //获取 对于index 位置的元素
    public T get(int index){
        checkIndex(index);
        return data[index];
    }
    //查看数组 是否包含元素e
    public boolean contains(T e){
        for(int i=0; i < size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    // 在index 位置 插入元素e， 时间复杂度O(m+n)
    public void add(int index,T e){
        checkIndex(index);
        //如果当前元素个数等于 素组容量， 将素组扩容维原来的2倍，拷贝当前数组
        if(size == data.length) {
            resize(1 << data.length);
        }
        for(int i = size -1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] =e;
        size++;
    }
    //删除元素
    public T remove(int index){
        checkIndexForRemove(index);
        T ret = data[index];
        for(int i=index+1; i < size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size]=null;
        //缩容
        if(size == data.length /4 && data.length/2 != 0){
            resize(data.length>>1);
        }
        return ret;
    }

    private void checkIndex(int index){
        if(index<0 || index >size){
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    private void checkIndexForRemove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
        }
    }
    //扩容算法，时间复杂度O（N）
    private void resize(int capacity){
        T[] newData =(T[])new Object[capacity];

        for(int i=0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    public static void main(String[] str){

/*        GenericArray array = new GenericArray<Integer>(5);
        array.add(0, 3);
        array.add(0, 4);
        array.add(1, 5);
        array.add(3, 9);
        array.add(3, 10);
        System.out.println(array.toString());*/
        System.out.println(3>>1);
    }
}

