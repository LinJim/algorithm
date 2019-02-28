package com.yunfu.leaf.algorithm.stack.test;

import com.yunfu.leaf.algorithm.stack.model.Stack;

import java.util.ArrayList;
import java.util.Random;


/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2018-09-15
 * @time: 17:39
 */
public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("stack.isEmpty()："+stack.isEmpty());
        stack.push(12);
        stack.push(13);
        stack.push(55);
        stack.push(66);
        stack.push(78);
        stack.push(44);
        System.out.println("stack.isEmpty()："+stack.isEmpty());
        System.out.println("stack.pop()："+stack.pop());
        System.out.println("stack.peek()："+stack.peek());
        System.out.println("stack.isFull()："+stack.isFull());
    }
}
