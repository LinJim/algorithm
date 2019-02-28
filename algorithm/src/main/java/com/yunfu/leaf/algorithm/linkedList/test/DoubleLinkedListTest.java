package com.yunfu.leaf.algorithm.linkedList.test;

import com.yunfu.leaf.algorithm.linkedList.model.DoubleLinkedList;
import com.yunfu.leaf.algorithm.linkedList.model.DoubleNode;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2018-10-19
 * @time: 1:32
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        // 测试在头节点后面插入新节点
        list.insertFirst(12);
        list.insertFirst(1);
        list.insertFirst(5);
        list.insertFirst(7);
        list.insertFirst(9);
        list.insertFirst(20);
        list.insertLast(11);
        list.insertLast(77);
        list.display();
        list.displayFirst();
        // 在头节点后面删除节点
        System.out.println("在头节点后面删除节点");
        list.deleteFirst();
        list.display();
        // 查找元素
        System.out.println("查找元素");
        DoubleNode node = list.find(12);
        if (node == null) {
            System.out.println("没找到元素");
        } else {
            node.display();
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        // 删除元素，根据数据域来删除
        list.delete(11);
        list.display();
        list.delete(1);
        list.display();
        list.delete(8);
        list.display();
        // 插入元素，插入在指定数据域结点的后面
//        list.insert(1,2);
//        list.display();
//        list.insert(9,8);
//        list.display();
//        list.insert(5,8);
//        list.display();
        list.insert(12, 8);
        list.display();
    }
}
