package com.yunfu.leaf.algorithm.linkedList.test;

import com.yunfu.leaf.algorithm.linkedList.model.LinkedList;
import com.yunfu.leaf.algorithm.linkedList.model.Node;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2018-10-16
 * @time: 14:44
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // 测试在头节点后面插入新节点
        list.insertFirst(12);
        list.insertFirst(1);
        list.insertFirst(5);
        list.insertFirst(7);
        list.insertFirst(9);
        list.insertFirst(20);
        list.insertFirst(11);
        list.display();
        list.displayFirst();
        // 在头节点后面删除节点
        list.deleteFirst();
        list.display();
        // 查找元素
        Node node = list.find(12);
        if (node == null) {
            System.out.println("没找到元素");
        }else {
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
        list.insert(12,8);
        list.display();
    }
}
