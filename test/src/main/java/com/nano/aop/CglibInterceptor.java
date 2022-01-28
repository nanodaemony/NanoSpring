/**
 * @(#)CglibInterceptor.java, 1月 25, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.aop;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 *
 *
 * @author chenzeng
 * @date 2022/1/25 6:44 下午
 * @version 0.0.1
 */
public class CglibInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("intercept start");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("intercept end");
        return result;
    }
}
