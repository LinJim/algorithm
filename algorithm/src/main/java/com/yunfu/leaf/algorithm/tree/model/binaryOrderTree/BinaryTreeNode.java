package com.yunfu.leaf.algorithm.tree.model.binaryOrderTree;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 二叉树节点
 * @date: 2018-10-26
 * @time: 1:34
 */
public class BinaryTreeNode {
    // 数据项
    public long data;
    // 数据项
    public String sData;
    // 左子节点
    public BinaryTreeNode leftChild;
    // 右子节点
    public BinaryTreeNode rightChild;

    public BinaryTreeNode(long data) {
        this.data = data;
    }

    public BinaryTreeNode(long data, String sData) {
        this.data = data;
        this.sData = sData;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public String getsData() {
        return sData;
    }

    public void setsData(String sData) {
        this.sData = sData;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * 判断是否有左节点
     *
     * @return boolean
     */
    public boolean hasLeftNode() {
        return this.leftChild != null;
    }

    /**
     * 判断是否有右节点
     *
     * @return boolean
     */
    public boolean hasRightNode() {
        return this.rightChild != null;
    }
}