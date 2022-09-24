/**
 * @(#)ControllerMonitorInterceptor.java, 4月 16, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.aop;

import java.io.IOException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Controller监控
 *
 * @author chenzeng
 * @date 2022/4/16 6:12 下午
 * @version 0.0.1
 */
@Aspect
@Component
public class ControllerMonitorInterceptor {

    //private static final Logger logger = LoggerFactory.getLogger(ControllerMonitorInterceptor.class);

    @Pointcut("execution(* com.nano.controller..*Controller.*(..))")
    public void controllerMonitor() {
    }

    /**
     * 记录Controller层异常.
     * 收集尽量多的参数.方便定位问题. 同时形成报警监控，报警信息里面提供充分的信息.
     *
     * @param jp 切点
     * @param ex 异常类型
     * @throws Throwable 异常对象
     */
    @AfterThrowing(throwing = "ex", pointcut = "controllerMonitor()")
    public void monitorControllerHandleException(JoinPoint jp, Throwable ex) throws Throwable {

        String shotSig = jp.getSignature().toShortString();

        // 分析异常

        // 发送报警信息
    }

}