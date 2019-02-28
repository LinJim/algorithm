package com.yunfu.leaf.algorithm.tree.test;

import com.yunfu.leaf.algorithm.tree.model.genericTree.GenericTree;
import com.yunfu.leaf.algorithm.tree.model.genericTree.GenericTreeNode;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 普通树测试
 * @date: 2018-12-14
 * @time: 16:30
 */
public class GenericTreeTest {
    public static void main(String[] args) {
        // 创建一棵树
        GenericTree genericTree = new GenericTree();
        // 创建一颗根节点
        GenericTreeNode root = new GenericTreeNode(1);
        // 设置根节点
        genericTree.setRoot(root);

        // 创建一颗左节点
        GenericTreeNode left = new GenericTreeNode(2);
        // 创建一颗右节点
        GenericTreeNode right = new GenericTreeNode(3);
        root.setLeftNode(left);
        root.setRightNode(right);

        // 为第二层节点都创建左右两个左右节点
        left.setLeftNode(new GenericTreeNode(5));
        left.setRightNode(new GenericTreeNode(6));

        right.setLeftNode(new GenericTreeNode(7));
        right.setRightNode(new GenericTreeNode(8));


        genericTree.preOrderTraverse(genericTree.getRoot());

        genericTree.delete(8);
        System.out.println("----------------------");
        genericTree.preOrderTraverse(genericTree.getRoot());
    }
}
