package com.yunfu.leaf.algorithm.queue.model;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 循环队列
 * @date: 2018-09-18
 * @time: 1:30
 */
public class CycleQueue {
    /**
     * 底层数组
     */
    private long[] arr;

    /**
     * 有效数据 valid data
     */
    private int element;

    /**
     * 队头
     */
    private int front;

    /**
     * 队尾
     */
    private int end;

    /**
     * 无参构造方法
     */
    public CycleQueue() {
        arr = new long[10];
        element = 0;
        front = 0;
        end = -1;
    }

    /**
     * 有参构造方法
     */
    public CycleQueue(int initialCapacity) {
        arr = new long[initialCapacity];
        element = 0;
        front = 0;
        end = -1;
    }

    /**
     * 从队列的尾部添加数据
     */
    public void insert(long value) {
        if (end == arr.length - 1) {
            end = -1;
        }
        arr[++end] = value;
        element++;
    }

    /**
     * 从队列的头部删除数据
     */
    public long remove() {
        long value = arr[front++];
        if (front == arr.length) {
            front = 0;
        }
        element--;
        return value;
    }

    /**
     * 查看元素
     */
    public long peek() {
        return arr[front];
    }


    /**
     * 是否满了
     */
    public boolean isFull() {
        return element == arr.length;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return element == 0;
    }

}
