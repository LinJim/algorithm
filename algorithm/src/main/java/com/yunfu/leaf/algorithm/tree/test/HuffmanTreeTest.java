package com.yunfu.leaf.algorithm.tree.test;

import com.yunfu.leaf.algorithm.tree.model.huffmanTree.HuffmanTree;
import com.yunfu.leaf.algorithm.tree.model.huffmanTree.HuffmanTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 哈夫曼树测试
 * @date: 2018-12-18
 * @time: 10:48
 */
public class HuffmanTreeTest {
    public static void main(String[] args) {
        int[] arr = {3, 7, 9, 29, 5, 11, 23, 14};
        HuffmanTree tree = new HuffmanTree();
        HuffmanTreeNode root = tree.createHuffmanTree(arr);
        //System.out.println(root.value);
        List<List<String>> lists = tree.printTree(root);
        for (List<String> list : lists) {
            System.out.println(list);
        }

    }
}
