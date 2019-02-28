package com.yunfu.leaf.algorithm.recursion.test;

import com.yunfu.leaf.algorithm.recursion.model.Recursion;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2018-10-19
 * @time: 11:52
 */
public class RecursionTest {

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        // recursion.test();
        // recursion.printf(100);
//        int i = recursion.getTriangleNumberByCycle(100);
//        int j = recursion.getTriangleNumberByRecursion(100);
//        System.out.println("i: " + i);
//        System.out.println("j: " + j);

        int k = recursion.getFibonacciByRecursion(20);
        System.out.println("k: " + k);

        int k2 = recursion.getFibonacciByRecursion2(20);
        System.out.println("k2: " + k2);

        int k3 = recursion.getFibonacciByRecursion3(20);
        System.out.println("k3: " + k3);

//        System.out.println("-----------------------------");
//        Recursion.doHanoiTower(3, 'A', 'B', 'C');

    }

}
