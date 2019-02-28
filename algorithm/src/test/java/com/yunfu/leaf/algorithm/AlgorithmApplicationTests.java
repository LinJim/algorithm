package com.yunfu.leaf.algorithm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.tree.TreeNode;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgorithmApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 3,3,3,3};
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

    }

}
