package com.yunfu.leaf.algorithm.tree.test;

import com.yunfu.leaf.algorithm.tree.model.orderStorageTree.OrderStorageTree;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 测试顺序存储的二叉树先序遍历
 * @date: 2018-12-14
 * @time: 19:57
 */
public class OrderStorageTreeTest {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 9, 7};
        OrderStorageTree tree = new OrderStorageTree(arr);
        tree.preOrderTraverse(0);
    }
}
