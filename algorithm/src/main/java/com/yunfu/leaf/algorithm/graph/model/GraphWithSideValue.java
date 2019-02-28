package com.yunfu.leaf.algorithm.graph.model;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 有路径值的图
 * @date: 2018-12-18
 * @time: 12:01
 */
public class GraphWithSideValue {

    /**
     * 顶点数组
     */
    private int[] vertexs;
    /**
     * 顶点数量
     */
    private int vertexSize;

    /**
     * 二维数组：邻接链表，表示顶点和顶点之前的路径
     */
    private int[][] matrix;

    /**
     * 最大的路径值，表示顶点不连接
     */
    private static final int MAX_WEIGHT = 1000;

    /**
     * 顶点是否被访问过
     */
    private boolean[] isVisited;

    /**
     * 记录的是 v0 到某顶点的最短路径和
     */
    private int[] shortTablePath;

    /**
     * 构造图
     *
     * @param vertexSize 顶点数目
     */
    public GraphWithSideValue(int vertexSize) {
        this.vertexSize = vertexSize;
        // 初始化邻接数组，matrix[0][1] 表示顶点一和顶点二的边值
        matrix = new int[vertexSize][vertexSize];
        // 初始化顶点数组：第一个顶点，第二个顶点。。。。。
        vertexs = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            vertexs[i] = i;
        }
        // 表示所有的顶点都没被访问过，因为 boolean 数组初始化值就是 false
        isVisited = new boolean[vertexSize];
        // 记录的是 v0 到某顶点的最短路径和
        shortTablePath = new int[vertexSize];
    }


    /**
     * 获取一个图的最短路径: 比如 v0----v8
     * 首先获取 v0 到 v8 初始化的时候的路径值数组
     * 每一次取 v0 到 v8 路径值数组得每一个值，第一次取 v0-v1,第二次取 v0-v2，
     * 取完 v0-v1 的值，然后遍历 v1 到 v2 ,v3 ,v4 .... 的值，和之前的 v0-v1 的值相加，然后和本身 v0 到 v2 ,v3 ,v4 .... 的值相比，覆盖掉
     * 循环取值：第二次就取 v0-v2
     */
    public void shortestPathDijstra(GraphWithSideValue graph) {
        int min;
        // 记录下标
        int k = 0;
        // 标记 v0 顶点是否拿到了到某一个顶点的路径
        boolean isGetPath[] = new boolean[graph.vertexSize];
        for (int v = 0; v < vertexSize; v++) {
            // 获取 v0 这一行的路径值数组：{0, 1, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
            // 即 v0 到 v0 v1 v2 ... 的距离
            shortTablePath[v] = graph.matrix[0][v];
        }
        // 表示 v0 这个顶点到 v0 的距离为 0
        shortTablePath[0] = 0;
        // 表示 v0 这个顶点拿到了到 v0 的距离
        isGetPath[0] = true;
        // 从 v1 开始遍历
        for (int v = 1; v < graph.vertexSize; v++) {
            // 设置最小值
            min = GraphWithSideValue.MAX_WEIGHT;
            // 取出第一行的相应路径，第一次取 v0-v1,第二次取 v0-v2，{0, 1, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT}; 就是 1
            for (int w = 0; w < graph.vertexSize; w++) {
                if (!isGetPath[w] && shortTablePath[w] < min) {
                    k = w;
                    min = shortTablePath[w];
                }
            }
            // 拿到了 v0 到 k 顶点的最短路径，所以为 true，第一次 k=1
            isGetPath[k] = true;
            // 再取 v1 到 v2,v3,v4.... 的距离，将 v0 到 v1 的距离+v1 到 v2 和 v0-v2 距离相比，然后覆盖，再取 v0 到 v1 的距离+ v1 到 v3 距离和 v0-v2 距离相比
            for (int j = 0; j < graph.vertexSize; j++) {
                if (!isGetPath[j] && (min + graph.matrix[k][j] < shortTablePath[j])) {
                    shortTablePath[j] = min + graph.matrix[k][j];
                }
            }
        }
        for (int i = 0; i < shortTablePath.length; i++) {
            System.out.println("V0到V" + i + "的最短路径为:" + shortTablePath[i] + "\n");
        }

    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        // 构建 9 个顶点的图
        GraphWithSideValue graph = new GraphWithSideValue(9);

        int[] a0 = new int[]{0, 1, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a1 = new int[]{1, 0, 3, 7, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a2 = new int[]{5, 3, 0, MAX_WEIGHT, 1, 7, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a3 = new int[]{MAX_WEIGHT, 7, MAX_WEIGHT, 0, 2, MAX_WEIGHT, 3, MAX_WEIGHT, MAX_WEIGHT};
        int[] a4 = new int[]{MAX_WEIGHT, 5, 1, 2, 0, 3, 6, 9, MAX_WEIGHT};
        int[] a5 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 7, MAX_WEIGHT, 3, 0, MAX_WEIGHT, 5, MAX_WEIGHT};
        int[] a6 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 3, 6, MAX_WEIGHT, 0, 2, 7};
        int[] a7 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 9, 5, 2, 0, 4};
        int[] a8 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 7, 4, 0};

        graph.matrix[0] = a0;
        graph.matrix[1] = a1;
        graph.matrix[2] = a2;
        graph.matrix[3] = a3;
        graph.matrix[4] = a4;
        graph.matrix[5] = a5;
        graph.matrix[6] = a6;
        graph.matrix[7] = a7;
        graph.matrix[8] = a8;

        graph.shortestPathDijstra(graph);

    }


}
