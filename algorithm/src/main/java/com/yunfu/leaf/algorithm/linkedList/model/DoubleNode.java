package com.yunfu.leaf.algorithm.linkedList.model;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 双向链表节点
 * @date: 2018-10-19
 * @time: 0:57
 */
public class DoubleNode {
    /**
     * 数据域
     */
    protected long data;
    /**
     * 指针域：指向下个节点
     */
    protected DoubleNode next;
    /**
     * 指针域：指向上个节点
     */
    protected DoubleNode previous;

    /**
     * 构造器初始化参数
     *
     * @param value 值
     */
    public DoubleNode(long value) {
        this.data = value;
    }

    /**
     * 显示方法
     */
    public void display() {
        System.out.print(data + " ");
    }
}
