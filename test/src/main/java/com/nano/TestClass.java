package com.nano; /**
 * @(#)TestClass.java, 10月 24, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 *
 *
 * @author chenzeng
 * @date 2021/10/24 4:41 下午
 * @version 0.0.1
 */
public class TestClass {

	public static void main(String[] args) {

		ApplicationContext sc = new ClassPathXmlApplicationContext("applicationContext.xml");
		sc.getBean("testBean");
		System.out.println("OK");
	}


}