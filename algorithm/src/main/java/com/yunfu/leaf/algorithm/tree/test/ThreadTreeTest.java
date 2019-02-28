package com.yunfu.leaf.algorithm.tree.test;

import com.yunfu.leaf.algorithm.tree.model.threadTree.ThreadTree;
import com.yunfu.leaf.algorithm.tree.model.threadTree.ThreadTreeNode;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 线索二叉树线索化测试
 * @date: 2018-12-17
 * @time: 1:34
 */
public class ThreadTreeTest {
    public static void main(String[] args) {
        // 创建一棵树
        ThreadTree threadTree = new ThreadTree();
        // 创建一颗根节点
        ThreadTreeNode root = new ThreadTreeNode(3);
        // 设置根节点
        threadTree.setRoot(root);

        // 创建一颗左节点
        ThreadTreeNode left = new ThreadTreeNode(8);
        // 创建一颗右节点
        ThreadTreeNode right = new ThreadTreeNode(16);
        root.setLeftNode(left);
        root.setRightNode(right);

        // 为第左节点都创建左右两个左右节点
        left.setLeftNode(new ThreadTreeNode(27));
        left.setRightNode(new ThreadTreeNode(88));
        // 例子中树的中序为：27 8 88 3 16，
        threadTree.inOrderThreadTree();
//        System.out.println(right.leftType);
//        System.out.println(right.leftNode.value);
        threadTree.inOrderTraverse();

    }

}
