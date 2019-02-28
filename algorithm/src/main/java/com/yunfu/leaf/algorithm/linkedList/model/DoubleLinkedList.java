package com.yunfu.leaf.algorithm.linkedList.model;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 双向链表，双端链表无法删除尾部元素，所以每个节点除了保存指向下个节点的引用 next ，还需要保存指向上个节点的引用 previous
 * @date: 2018-10-19
 * @time: 0:54
 */
public class DoubleLinkedList {
    /**
     * 头结点
     */
    private DoubleNode first;

    /**
     * 尾结点
     */
    private DoubleNode last;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
    }

    /**
     * 从头节点开始插入新节点 【新节点】--->【头结点】
     *
     * @param value 新节点的值
     */
    public void insertFirst(long value) {
        // 构建新节点
        DoubleNode temp = new DoubleNode(value);
        // 如果链表是 null 的,last 也放到这个节点上
        if (isEmpty()) {
            last = temp;
        } else {
            first.previous = temp;
        }
        // 插入逻辑,next 这个属性是 protected 类型，只能子类或者同包下可以引用
        temp.next = first;
        first = temp;
    }


    /**
     * 从尾节点开始插入新节点 【尾节点】--->【新结点】
     *
     * @param value 新节点的值
     */
    public void insertLast(long value) {
        // 构建新节点
        DoubleNode temp = new DoubleNode(value);
        // 如果链表是 null 的
        if (isEmpty()) {
            // 尾结点就是新增节点
            first = temp;
        } else {
            temp.previous = last;
            last.next = temp;
        }
        last = temp;
    }

    public void displayFirst() {
        first.display();
        System.out.println();
    }

    /**
     * 从头节点开始删除节点，【头结点（要删除）】-----【结点】
     *
     * @return
     */
    public DoubleNode deleteFirst() {
        // 拿到要删除结点
        DoubleNode temp = first;
        // 判断头结点后面有没有节点
        if (temp.next == null) {
            last = null;
        } else {
            temp.next.previous = null;
        }
        first = temp.next;
        return temp;
    }

    /**
     * 从尾节点开始删除节点，【结点】-----【尾结点（要删除）】
     *
     * @return
     */
    public DoubleNode deleteLast() {
        // 拿到要删除结点
        DoubleNode temp = last;
        // 判断头结点后面有没有节点
        if (first.next == null) {
            last = null;
        } else {
            // 此节点前一个节点的下一个节点为 null
            temp.previous.next = null;
            // 此节点前一个节点为 last
            last = temp.previous;
        }
        return temp;
    }

    /**
     * 显示方法: 记住一般方法要把  Node currentNode = first; 写出来，拿出当前结点，而不直接用 first 来修改，
     * 以防改变方法导致，其他方法报错，例如 null 指针
     */
    public void display() {
        DoubleNode currentNode = first;
        while (currentNode != null) {
            currentNode.display();
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    /**
     * 查找元素
     */
    public DoubleNode find(long value) {
        DoubleNode currentNode = first;
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
    public DoubleNode delete(long value) {
        DoubleNode currentNode = first;
        // 假设结点的数据不等于这个查找值，就会一直找下去，断开循环说明找到了
        while (currentNode.data != value) {
            // 直到结点的下个结点为 null ,就不用找了
            if (currentNode.next == null) {
                return null;
            }
            currentNode = currentNode.next;
        }
        // 如果是刚好是头结点的话
        if (currentNode == first) {
            first = first.next;
        } else {
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
        return currentNode;
    }

    /**
     * 插入元素，插入在指定数据域结点的后面
     */
    public void insert(long value, long data) {
        DoubleNode currentNode = first;
        DoubleNode insert = new DoubleNode(data);
        // 假设结点的数据不等于这个查找值，就会一直找下去，断开循环说明找到了
        while (currentNode.data != value) {
            // 直到结点的下个结点为 null ,就不用找了
            if (currentNode.next == null) {
                return;
            }
            currentNode = currentNode.next;
        }
        // 由于不管是不是头结点插入方法一致
        insert.next = currentNode.next;
        currentNode.next = insert;
        insert.previous = currentNode;
        currentNode.next.previous = insert;
    }


    /**
     * 判断是否为 null
     */
    public boolean isEmpty() {
        return first == null;
    }
}
