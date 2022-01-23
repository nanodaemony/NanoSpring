/**
 * @(#)MainConfig.java, 1月 10, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.config;

import com.nano.entity.Book;
import com.nano.entity.Pencil;
import com.nano.test.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 配置类
 *
 * @author chenzeng
 * @date 2022/1/10 9:15 下午
 * @version 0.0.1
 */
@Configuration
@ComponentScan(basePackages = "com.nano")
public class NanoConfig {

    @Bean(name = "testBean")
    public TestBean testBean() {
        return new TestBean();
    }

    @Bean
    @Lazy
    public Pencil pencil() {
        return new Pencil();
    }

    @Bean
    @Scope(value = "prototype")
    public Book book() {
        return new Book();
    }

}