package com.yunfu.leaf.algorithm.linkedList.model;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 单链表，相当于火车，定义里面只定义了头结点，就是因为可以通过指针域找到火车的车厢，即其他节点
 * @date: 2018-10-16
 * @time: 14:43
 */
public class LinkedList {
    /**
     * 链表头节点
     */
    private Node first;

    /**
     * 不初始化也可以，因为编译器默认会给没初始化的属性赋值
     */
    public LinkedList() {
        first = null;
    }

    /**
     * 在头节点后面插入新节点 【新节点】--->【头结点】
     *
     * @param value 新节点的值
     */
    public void insertFirst(long value) {
        // 构建新节点
        Node temp = new Node(value);
        // 插入逻辑,next 这个属性是 protected 类型，只能子类或者同包下可以引用
        temp.next = first;
        first = temp;
    }

    public void displayFirst() {
        first.display();
        System.out.println();
    }

    /**
     * 在头节点后面删除节点，【头结点】-----【要删除结点】-----【结点】
     *
     * @return
     */
    public Node deleteFirst() {
        // 拿到要删除结点
        Node temp = first.next;
        first.next = temp.next;
        return temp;
    }

    /**
     * 显示方法: 记住一般方法要把  Node currentNode = first; 写出来，拿出当前结点，而不直接用 first 来修改，
     * 以防改变方法导致，其他方法报错，例如 null 指针
     */
    public void display() {
        Node currentNode = first;
        while (currentNode != null) {
            currentNode.display();
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    /**
     * 查找元素
     */
    public Node find(long value) {
        Node currentNode = first;
        // 假设结点的数据不等于这个查找值，就会一直找下去，断开循环说明找到了
        while (currentNode.data != value) {
            // 直到结点的下个结点为 null ,就不用找了
            if (currentNode.next == null) {
                return null;
            }
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    /**
     * 删除元素，根据数据域来删除
     */
    public Node delete(long value) {
        Node currentNode = first;
        Node previous = first;
        // 假设结点的数据不等于这个查找值，就会一直找下去，断开循环说明找到了
        while (currentNode.data != value) {
            // 直到结点的下个结点为 null ,就不用找了
            if (currentNode.next == null) {
                return null;
            }
            previous = currentNode;
            currentNode = currentNode.next;
        }
        // 如果是刚好是头结点的话
        if (currentNode == first) {
            first = first.next;
        } else {
            previous.next = currentNode.next;
        }
        return currentNode;
    }

    /**
     * 插入元素，插入在指定数据域结点的后面
     */
    public void insert(long value, long data) {
        Node currentNode = first;
        Node insert = new Node(data);
        // 假设结点的数据不等于这个查找值，就会一直找下去，断开循环说明找到了
        while (currentNode.data != value) {
            // 直到结点的下个结点为 null ,就不用找了
            if (currentNode.next == null) {
                return;
            }
            currentNode = currentNode.next;
        }
//        // 如果是刚好是头结点的话
//        if (currentNode == first) {
//            temp.next = first.next;
//            first.next = temp;
//        } else {
//            temp.next = currentNode.next;
//            currentNode.next = temp;
//        }
        // 由于不管是不是头结点插入方法一致
        insert.next = currentNode.next;
        currentNode.next = insert;
    }

}
