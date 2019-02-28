package com.yunfu.leaf.algorithm.tree.model.threadTree;


/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 线索二叉树：平常的二叉树节点会有左右孩子，当左右孩子为 null 的时候，就不存储东西，那么第一造成指针浪费，第二就是不可以线索化找到节点的前驱节点和后继节点
 * @description: 实现前驱节点和后序节点的线索化二叉树（例子中序线索化，现在有二叉树（这是中序）：27,8,88,3,16 ，同时还有前序线索化：3 8 27 88 16）
 * @date: 2018-12-14
 * @time: 16:27
 */
public class ThreadTree {
    ThreadTreeNode root;

    // 用于临时存储前驱节点
    ThreadTreeNode pre = null;

    // 设置根节点
    public void setRoot(ThreadTreeNode root) {
        this.root = root;
    }

    // 获取根节点
    public ThreadTreeNode getRoot() {
        return root;
    }

    /**
     * 中序线索化
     * 例子：                   3
     * 8         16
     * 27   88
     */
    private void inOrderThreadTree(ThreadTreeNode node) {
        // 如果当前节点为 null ，直接返回
        if (node == null) {
            return;
        }
        // 处理左子树
        inOrderThreadTree(node.leftNode);
        // 处理前驱节点
        // 如果节点左子树为 null
        if (node.leftNode == null) {
            // 设置前驱节点
            node.leftType = 1;
            node.leftNode = pre;
        }
        // 处理前驱的右指针，如果节点右子树为 null
        if (pre != null && pre.rightNode == null) {
            // 设置后继节点
            pre.rightType = 1;
            // 让前驱节点的右指针指向当前节点
            pre.rightNode = node;
        }
        // 每处理一个节点，当前节点是下个节点的前驱节点
        pre = node;
        // 处理右子树
        inOrderThreadTree(node.rightNode);
    }

    /**
     * 中序线索化：从根节点开始
     */
    public void inOrderThreadTree() {
        inOrderThreadTree(root);
    }

    /**
     * 中序遍历线索二叉树
     */
    public void inOrderTraverse() {
        // 取出根节点
        ThreadTreeNode node = root;
        if (root == null) {
            return;
        }
        // 找出最左边结点(最左边结点 leftType 已经变成 1)，然后根据线索化，一直向右遍历
        while (node != null && node.leftType == 0) {
            node = node.leftNode;
        }
        System.out.println("值为：" + node.value);
        // 根据线索化，一直向右遍历
        while (node != null) {
            node=node.rightNode;
            if(node!=null){
                System.out.println("值为：" + node.value);
            }
        }


    }


}
