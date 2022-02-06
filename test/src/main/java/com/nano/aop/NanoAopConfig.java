/**
 * @(#)NanoAopConfig.java, 2月 02, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 *
 * @author chenzeng
 * @date 2022/2/2 7:14 下午
 * @version 0.0.1
 */
@Configuration
@EnableAspectJAutoProxy
public class NanoAopConfig {

    @Bean
    public NanoCalculate nanoCalculate() {
        return new NanoCalculate();
    }

}