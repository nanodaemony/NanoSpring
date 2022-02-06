/**
 * @(#)NanoAspect.java, 1月 25, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.aop;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
public class CalculateAspect {

    @Pointcut("execution(* com.nano.aop.Calculate.*(..))")
    public void pointCut(){};

    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【" + methodName + "】之前执行<前置通知>,入参" + Arrays.asList(joinPoint.getArgs()));
    }

    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【" + methodName + "】之前执行<后置通知>,入参" + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()")
    public void methodReturning(JoinPoint joinPoint ) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【" + methodName + "】之前执行<返回通知>,入参" + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterThrowing(value = "pointCut()")
    public void methodAfterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【" + methodName + "】之前执行<异常通知>,入参" + Arrays.asList(joinPoint.getArgs()));
    }

}