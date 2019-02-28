package com.yunfu.leaf.algorithm.tree.model.huffmanTree;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 哈夫曼二叉树节点
 * @date: 2018-12-14
 * @time: 16:26
 */
public class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {
    // 节点的权
    public int value;
    // 左孩子
    public HuffmanTreeNode leftNode;
    // 右孩子
    public HuffmanTreeNode rightNode;

    public HuffmanTreeNode(int value) {
        this.value = value;
    }


    @Override
    public int compareTo(HuffmanTreeNode o) {
        return this.value - o.value;
    }
}
