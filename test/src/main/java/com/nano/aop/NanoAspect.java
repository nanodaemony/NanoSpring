/**
 * @(#)NanoAspect.java, 1月 25, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author chenzeng
 * @date 2022/1/25 6:32 下午
 * @version 0.0.1
 */
@Component
@Aspect
public class NanoAspect {

    @Pointcut("execution(* com.nano.service..*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before() {
        System.out.println("before advice");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("after advice");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        try {
            System.out.println("入参 = " + JSON.toJSONString(args));
            long start = System.currentTimeMillis();
            Object result = pjp.proceed();
            System.out.println("耗时 = " + (System.currentTimeMillis() - start));
            System.out.println("回参 = " + JSON.toJSONString(result));
            return result;
        } catch (Exception e) {
            return "";
        }
    }

}