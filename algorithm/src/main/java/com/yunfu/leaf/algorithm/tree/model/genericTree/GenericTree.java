package com.yunfu.leaf.algorithm.tree.model.genericTree;


/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 普通二叉树
 * @date: 2018-12-14
 * @time: 16:27
 */
public class GenericTree {
    GenericTreeNode root;

    // 设置根节点
    public void setRoot(GenericTreeNode root) {
        this.root = root;
    }

    // 获取根节点
    public GenericTreeNode getRoot() {
        return root;
    }


    /**
     * 先序遍历：根左右
     * 其实是先访问 node.data ，再访问左子树，也是 node.data ,再访问右子树
     *
     * @param node 二叉树根节点
     */
    public void preOrderTraverse(GenericTreeNode node) {
        // 如果二叉树根节点不为 null
        if (node != null) {
            // 先访问根节点
            System.out.println("数据：" + node.value);
            // 再访问左子树
            preOrderTraverse(node.leftNode);
            // 再访问右子树
            preOrderTraverse(node.rightNode);
        }
    }

    /**
     * 普通二叉树删除子节点，其实就是删除子树：
     *
     * @param value 删除子节点的值
     */
    public void delete(int value) {
        // 如果删除节点刚好是根节点的话，令根节点为 null
        if (root.value == value) {
            root = null;
        } else {
            // 如果不是根节点的话，就调用节点的删除方法
            root.delete(value);
        }

    }
}
