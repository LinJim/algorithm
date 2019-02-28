package com.yunfu.leaf.algorithm.tree.model.threadTree;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 线索二叉树节点
 * @date: 2018-12-14
 * @time: 16:26
 */
public class ThreadTreeNode {
    // 节点的权
    public int value;
    // 左孩子
    public ThreadTreeNode leftNode;
    // 右孩子
    public ThreadTreeNode rightNode;
    // 类型标志指针：默认为 0 代表左孩子，为 1 代表前驱节点。
    public int leftType;
    // 类型标志指针：默认为 0 代表右孩子，为 1 代表后继节点。
    public int rightType;

    public ThreadTreeNode(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ThreadTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(ThreadTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public ThreadTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(ThreadTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
}
