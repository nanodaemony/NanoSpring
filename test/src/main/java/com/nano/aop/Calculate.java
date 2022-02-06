/**
 * @(#)Calculate.java, 2月 03, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.aop;

/**
 *
 *
 * @author chenzeng
 * @date 2022/2/3 3:50 下午
 * @version 0.0.1
 */
public interface Calculate {

    int add(int numA,int numB);

    int sub(int numA, int numB);

    int div(int numA,int numB);

    int multi(int numA,int numB);
}