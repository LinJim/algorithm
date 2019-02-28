package com.yunfu.leaf.algorithm.tree.model.genericTree;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 普通二叉树节点
 * @date: 2018-12-14
 * @time: 16:26
 */
public class GenericTreeNode {
    // 节点的权
    int value;
    // 左孩子
    GenericTreeNode leftNode;
    // 右孩子
    GenericTreeNode rightNode;

    public GenericTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public GenericTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(GenericTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public GenericTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(GenericTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * 删除节点：最主要是找到他的父节点，直接令他的父节点的左孩子或者右孩子为 null
     */
    public void delete(int value) {
        // 先标记父节点(父节点为调用方法的节点)，因为当你删除子节点的时候，你要找回父节点设置他的孩子为 null
        GenericTreeNode parent = this;
        // 先判断他的左节点是不是等于删除的值
        if (parent.leftNode != null && parent.leftNode.value == value) {
            parent.leftNode = null;
            return;
        }
        // 再判断他的右节点是不是等于删除的值
        if (parent.rightNode != null && parent.rightNode.value == value) {
            parent.rightNode = null;
            return;
        }
        // 如果都不是，1. parent 变成左节点
        // 其实这里很多时候习惯性会 parent = parent.leftNode; 这个逻辑上其实没有错，但是因为 parent 有可能为 null，这样就会引发空指针异常，所以还不如不写
        parent = leftNode;
        if (parent != null) {
            parent.delete(value);
        }
        // 如果都不是，2. parent 变成右节点
        parent = rightNode;
        if (parent != null) {
            parent.delete(value);
        }


    }
}
