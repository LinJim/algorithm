package com.yunfu.leaf.algorithm.array.controller;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2018-09-03
 * @time: 20:28
 */

import com.yunfu.leaf.algorithm.array.test.TestArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArrayController {

    @RequestMapping(value = "/testClassNotInitialize", method = RequestMethod.GET)
    @ResponseBody
    public TestArray testArray() {
        // 得到没初始化的类属性初始值，基础类型为 0 ，对象类型为 null
        return new TestArray();
    }

}
