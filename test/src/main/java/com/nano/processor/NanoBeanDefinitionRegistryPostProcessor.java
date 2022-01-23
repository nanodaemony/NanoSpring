/**
 * @(#)NanoBeanDefinitionRegistryPostProcessor.java, 1月 22, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author chenzeng
 * @date 2022/1/22 7:47 下午
 * @version 0.0.1
 */
@Component
public class NanoBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, Ordered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("NanoBeanDefinitionRegistryPostProcessor类的postProcessBeanFactory方法...");
        // 自己的逻辑处理
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("NanoBeanDefinitionRegistryPostProcessor类的postProcessBeanDefinitionRegistry方法...");
        // 自己的逻辑处理
    }

    @Override
    public int getOrder() {
        return 0;
    }
}