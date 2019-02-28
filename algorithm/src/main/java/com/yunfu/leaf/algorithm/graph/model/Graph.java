package com.yunfu.leaf.algorithm.graph.model;

import com.yunfu.leaf.algorithm.queue.model.Queue;
import com.yunfu.leaf.algorithm.stack.model.Stack;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 图类：实现方法有邻接矩阵，邻接链表，遍历方法，广度优先算法和深度优先算法
 * @date: 2018-11-13
 * @time: 20:48
 */
public class Graph {
    /**
     * 顶点数组
     */
    private Vertex[] vertex;

    /**
     * 邻接（adjacent）矩阵：代表边相邻
     */
    private int[][] adjMatrix;

    /**
     * 顶点最大数目
     */
    private int maxSize;

    /**
     * 当前顶点
     */
    private int nVertex;

    /**
     * 栈
     */
    private Stack stack;

    private Queue queue;

    public Graph(int capacity) {
        vertex = new Vertex[capacity];
        adjMatrix = new int[capacity][capacity];
        maxSize = capacity;
        // 初始化邻接矩阵
        initAdjMatrix();
        // 当前顶点从第一个开始
        nVertex = 0;
        stack = new Stack();
        queue = new Queue();
    }

    /**
     * 初始化邻接矩阵
     */
    private void initAdjMatrix() {
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    /**
     * 添加顶点
     *
     * @param label
     */
    public void addVertex(char label) {
        vertex[nVertex++] = new Vertex(label);
    }

    /**
     * 添加边
     *
     * @param start 开始顶点
     * @param end   结束顶点
     */
    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    /**
     * 深度优先算法：从初始顶点开始，访问其邻接顶点，再访问邻接顶点的下个邻接顶点，一直访问，知道没邻接顶点可以访问
     * 倒退回上个顶点，再访问上个顶点的下个邻接顶点，没有再倒退，重复此过程，直到最后一个顶点是初始顶点
     * 且为终点。
     */
    public void dfs() {
        // 首先访问 0 号顶点，并设置顶点已经被访问过
        vertex[0].isVisited = true;
        // 打印此顶点
        display(0);
        // 压入栈中，这里使用栈这种数据结构是因为找不到邻接顶点需要后退到上个顶点，再找
        stack.push(0);

        // 当栈不为空
        while (!stack.isEmpty()) {
            // 取出邻接顶点,使用栈的栈顶元素查看方法
            int adjVertex = getAdjVertex((int) stack.peek());
            // 如果有邻接顶点，就访问，并压栈，否则没有邻接顶点，出栈
            if (adjVertex != -1) {
                display(adjVertex);
                vertex[adjVertex].isVisited = true;
                stack.push(adjVertex);
            } else {
                stack.pop();
            }
        }

        // 搜索完之后，把信息修改为初始状态
        for (int i = 0; i < nVertex; i++) {
            vertex[i].isVisited = false;
        }
    }

    /**
     * 广度优先算法(Breadth-First Search)：从初始顶点开始，访问其所有邻接顶点，然后遍历其每个邻接顶点，再访问这个邻接顶点的所有邻接顶点
     * 简单来说：就是访问初始顶点，然后访问出度为 1 的邻接顶点，再访问出度为 2 的邻接顶点，层层访问
     */
    public void bfs() {
        // 首先访问 0 号顶点，并设置顶点已经被访问过
        vertex[0].isVisited = true;
        // 打印此顶点
        display(0);
        // 插入队列，这里使用队列的原因是要访问所有邻接顶点，队列一个个出列
        queue.insert(0);

        // 当队列不为空
        while (!queue.isEmpty()) {
            // 取出邻接顶点,使用队列的队头元素查看方法
            int adjVertex = getAdjVertex((int) queue.peek());
            // 如果有邻接顶点，就访问，并插入队列，否则没有邻接顶点，出队
            if (adjVertex != -1) {
                display(adjVertex);
                vertex[adjVertex].isVisited = true;
                queue.insert(adjVertex);
            } else {
                queue.remove();
            }
        }

        // 搜索完之后，把信息修改为初始状态
        for (int i = 0; i < nVertex; i++) {
            vertex[i].isVisited = false;
        }
    }

    /**
     * 访问顶点
     *
     * @param v 当前顶点
     */
    private void display(int v) {
        System.out.println(vertex[v].label);
    }

    /**
     * 得到邻接顶点
     *
     * @param v 邻接矩阵的索引位置
     * @return
     */
    private int getAdjVertex(int v) {
        // 遍历，取出此顶点邻接矩阵中值为 1 的点，即两个点为邻接顶点,且此顶点没有被访问过
        for (int i = 0; i < nVertex; i++) {
            if (!vertex[i].isVisited && adjMatrix[v][i] == 1) {
                return i;
            }
        }
        return -1;
    }


}
