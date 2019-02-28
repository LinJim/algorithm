package com.yunfu.leaf.algorithm.graph.model;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 顶点类
 * @date: 2018-11-13
 * @time: 20:49
 */
public class Vertex {
    /**
     * 顶点的标签
     */
    public char label;

    /**
     * 是否被访问过
     */
    public boolean isVisited;


    public Vertex(char label) {
        this.label = label;
    }
}
