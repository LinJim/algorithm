package com.yunfu.leaf.algorithm.graph.test;

import com.yunfu.leaf.algorithm.graph.model.Graph;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 图 测试
 * @date: 2018-11-13
 * @time: 21:07
 */
public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');


        /**
         *   A      A 连 B 和 C ，C 连 D ，D 连 E
         * B   C
         *     D
         *     E
         */

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);


        /**
         *   A      A 连 B 和 C ，B 连 D ，C 连 E
         * B   C
         * D   E
         *
         */
//        graph.addEdge(0,1);
//        graph.addEdge(0,2);
//        graph.addEdge(1,3);
//        graph.addEdge(2,4);

        graph.bfs();
    }
}
