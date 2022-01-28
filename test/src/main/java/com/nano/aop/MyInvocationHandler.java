/**
 * @(#)MyInvocationHandler.java, 1月 25, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.aop;

import com.nano.service.LoginService;
import com.nano.service.impl.LoginServiceImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 *
 * @author chenzeng
 * @date 2022/1/25 6:40 下午
 * @version 0.0.1
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object origin;

    public MyInvocationHandler(Object origin) {
        this.origin = origin;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke start");
        Object result = method.invoke(origin, args);
        System.out.println("invoke end");
        return result;
    }

}

