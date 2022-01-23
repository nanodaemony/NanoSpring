/**
 * @(#)NanoEvent.java, 1月 14, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.event;

import org.springframework.context.ApplicationEvent;

/**
 *
 *
 * @author chenzeng
 * @date 2022/1/14 7:44 下午
 * @version 0.0.1
 */
public class NanoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 7099057708183571932L;

    public NanoEvent(Object source) {
        super(source);
        System.out.println("@@@@@@@@@@@@@@@@@");
    }
}