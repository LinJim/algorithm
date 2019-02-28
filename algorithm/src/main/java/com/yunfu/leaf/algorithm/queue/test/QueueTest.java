package com.yunfu.leaf.algorithm.queue.test;

import com.yunfu.leaf.algorithm.queue.model.Queue;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2018-09-15
 * @time: 17:39
 */
public class QueueTest {

    public static void main(String[] args) {
        // 测试队列是否为空或者满
        Queue queue1 = new Queue();
        System.out.println("queue1.isEmpty():" + queue1.isEmpty());
        System.out.println("queue1.isFull():" + queue1.isFull());


        Queue queue2 = new Queue(4);
        System.out.println("queue2.isEmpty():" + queue2.isEmpty());
        System.out.println("queue2.isFull():" + queue2.isFull());
        queue2.insert(2);
        queue2.insert(5);
        queue2.insert(8);
        queue2.insert(7);

        System.out.println("queue2.isEmpty():" + queue2.isEmpty());
        System.out.println("queue2.isFull():" + queue2.isFull());

        // 测试队列的查看插入删除
        Queue queue3 = new Queue(4);
        queue3.insert(2);
        queue3.insert(5);
        queue3.insert(8);
        queue3.insert(7);

        System.out.println("queue3.peek():" + queue3.peek());
        System.out.println("queue3.peek():" + queue3.peek());

        while (!queue3.isEmpty()){
            System.out.println("queue3.remove():" +  queue3.remove());
        }
        queue3.insert(9);
        queue3.insert(10);
        System.out.println("queue3.peek():" + queue3.peek());

    }
}
