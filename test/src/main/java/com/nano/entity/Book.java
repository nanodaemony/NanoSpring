/**
 * @(#)Book.java, 1月 17, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.entity;

import org.springframework.stereotype.Component;

/**
 *
 *
 * @author chenzeng
 * @date 2022/1/17 7:40 下午
 * @version 0.0.1
 */
@Component
public class Book {

    private String name;

    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}