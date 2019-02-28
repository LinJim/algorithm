package com.yunfu.leaf.algorithm.hashTable.linkedListAdress;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 链表中节点，相当于火车的车厢
 * @date: 2018-10-16
 * @time: 14:43
 */
public class Node {
    /**
     * 数据域
     */
    protected Info data;
    /**
     * 指针域
     */
    protected Node next;

    /**
     * 构造器初始化参数
     *
     * @param value 值
     */
    public Node(Info value) {
        this.data = value;
    }

    /**
     * 显示方法
     */
    public void display() {
        System.out.print(data + " ");
    }
}
