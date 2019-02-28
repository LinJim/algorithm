package com.yunfu.leaf.algorithm;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description
 * @date 2018-09-03
 * @time 19:46
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AlgorithmApplication.class);
    }

}