package com.yunfu.leaf.algorithm.queue.model;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 自定义队列
 * @date: 2018-09-15
 * @time: 17:30
 */
public class Queue {
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
    public Queue() {
        arr = new long[10];
        element = 0;
        front = 0;
        end = -1;
    }

    /**
     * 有参构造方法
     */
    public Queue(int initialCapacity) {
        arr = new long[initialCapacity];
        element = 0;
        front = 0;
        end = -1;
    }

    /**
     * 从队列的尾部添加数据
     */
    public void insert(long value) {
        arr[++end] = value;
        element++;
    }

    /**
     * 从队列的头部删除数据
     */
    public long remove() {
        element--;
        return arr[front++];
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
