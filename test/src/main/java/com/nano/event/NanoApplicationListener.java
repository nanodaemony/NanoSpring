/**
 * @(#)NanoApplicationListener.java, 1月 14, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义事件监听器
 *
 * @author chenzeng
 * @date 2022/1/14 7:39 下午
 * @version 0.0.1
 */
@Component
public class NanoApplicationListener implements ApplicationListener<ApplicationEvent> {

    // 接受到消息 回调该方法
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        System.out.println("Get a event: " + event.getSource());
    }

}
