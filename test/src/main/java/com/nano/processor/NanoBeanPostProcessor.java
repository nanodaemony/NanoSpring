/**
 * @(#)NanoBeanPostProcessor.java, 1月 22, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.processor;

import com.nano.service.LoginService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author chenzeng
 * @date 2022/1/22 10:46 下午
 * @version 0.0.1
 */
@Component
public class NanoBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor#postProcessBeforeInitialization");
        if (bean instanceof LoginService) {
            System.out.println(beanName);
        }
        // 自己的逻辑
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("NanoBeanPostProcessor类的postProcessAfterInitialization方法...");
        // 自己的逻辑
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}