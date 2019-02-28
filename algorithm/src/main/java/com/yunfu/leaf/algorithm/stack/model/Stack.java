package com.yunfu.leaf.algorithm.stack.model;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 自定义栈
 * @date: 2018-09-15
 * @time: 17:28
 */
public class Stack {
    /**
     * 底层实现是一个数组
     */
    private long[] arr;

    /**
     * 栈顶
     */
    private int top;

    /**
     * 默认的构造方法
     */
    public Stack() {
        arr = new long[10];
        top = -1;
    }

    /**
     * 带参数的构造方法
     *
     * @param initialCapacity 初始容量
     */
    public Stack(int initialCapacity) {
        arr = new long[initialCapacity];
        top = -1;
    }


    /**
     * 添加数据
     */
    public void push(long value) {
        arr[++top] = value;
    }

    /**
     * 删除数据
     */
    public long pop() {
        return arr[top--];
    }

    /**
     * 查看元素
     */
    public long peek() {
        return arr[top];
    }


    /**
     * 是否满了
     */
    public boolean isFull() {
        return top == arr.length - 1;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return top == -1;
    }


}
