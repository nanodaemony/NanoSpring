/**
 * @(#)NanoCondition.java, 2月 16, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 *
 *
 * @author chenzeng
 * @date 2022/2/16 6:14 下午
 * @version 0.0.1
 */
public class NanoCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 判断容器中是否有pencil组件
        if(context.getBeanFactory().containsBean("pencil")) {
            return true;
        }
        return false;
    }
}