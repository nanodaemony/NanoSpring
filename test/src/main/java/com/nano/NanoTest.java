package com.nano; /**
 * @(#)TestClass.java, 10月 24, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import com.nano.event.NanoEvent;
import com.nano.config.NanoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 *
 * @author chenzeng
 * @date 2021/10/24 4:41 下午
 * @version 0.0.1
 */
public class NanoTest {

	public static void main(String[] args) {
//		ApplicationContext sc = new ClassPathXmlApplicationContext("applicationContext.xml");
//		sc.getBean("testBean");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NanoConfig.class);
//
		context.getBean("book");

		System.out.println("*****");
		// 手动发布一个事件
		context.publishEvent(new NanoEvent("Publish nano event...."));
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 容器关闭也发布事件
		context.close();
	}

}


