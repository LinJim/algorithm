package com.yunfu.leaf.algorithm.tree.test;

import com.yunfu.leaf.algorithm.tree.model.binaryOrderTree.BinaryTree;

import java.util.List;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 二叉树测试
 * @date: 2018-10-26
 * @time: 21:48
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(40);
        binaryTree.insert(10);
        binaryTree.insert(55);
        binaryTree.insert(44);
        binaryTree.insert(2);
        binaryTree.insert(65);
        binaryTree.insert(21);
        binaryTree.insert(30);
        binaryTree.insert(18);
//        binaryTree.insert(20);
//        binaryTree.insert(1);
//        binaryTree.insert(5);
        binaryTree.insert(45);
//        binaryTree.insert(64);
        // 测试先序、中序、后序遍历
        //binaryTree.preOrderTraverse(binaryTree.getRoot());
        //binaryTree.preOrderTraverseSearch(binaryTree.getRoot(),32);
        //binaryTree.inOrderTraverse(binaryTree.getRoot());
        //binaryTree.afterOrderTraverse(binaryTree.getRoot());
        // 测试二叉树打印
//        List<List<String>> list = binaryTree.printTree(binaryTree.getRoot());
//        for (List<String> list1 : list) {
//            System.out.println(list1);
//        }
//        System.out.println();
        //System.out.println(binaryTree.getRoot()==null);
//        System.out.println();

        // 测试查询节点
//        BinaryTreeNode node = binaryTree.find(10);
//        System.out.println(node.data);
//        BinaryTreeNode node1 = binaryTree.find(31);
//        System.out.println("node: "+node1);

        // 测试删除节点：1.删除叶子节点 2.删除只有一个孩子的节点 3.删除拥有两个孩子的节点
//        System.out.println(binaryTree.delete(10));
//        // 测试二叉树打印
//        binaryTree.inOrderTraverse(binaryTree.getRoot());
//        System.out.println();
          // 测试普通二叉树删除子节点
//        binaryTree.deleteByGeneralTree(10);
        List<List<String>> list2 = binaryTree.printTree(binaryTree.getRoot());
        for (List<String> list1 : list2) {
            System.out.println(list1);
        }
//        System.out.println();

    }

}
