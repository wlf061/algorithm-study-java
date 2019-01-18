package com.wlf.algorithm.niukewang.Chapter3;

/**
 * 测试java 的引用作为参数
 *
 * @author nancy.wang
 * @Time 2019/1/17
 */
public class TestReference {
    public static void main(String[] args) {
        Person p1 = new Person(10);
        modify(p1);  //修改p1引用的对象
        System.out.println(p1);
    }

    /***
     * 引用的传递：
     * 1.这种调用方式相当于复制了一份 p1 的地址给p,p 和p1 指向同一块地址
     * 2. 在modify 中改变了p的指向。
     * 3. 原来的p1 还是p1.
     * @param p
     */
    public static void modify(Person p){ //使用此函数修改引用的指向，
        p = new Person(20);
    }



}

class Person {   //实验用类
    public int age;
    @Override
    public String toString() {
        return "Person [age=" + age + "]";
    }

    public Person(int age) {
        this.age = age;
    }
}
