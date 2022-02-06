/**
 * @(#)TulingCalculate.java, 2月 03, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.aop;

import java.util.Arrays;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author chenzeng
 * @date 2022/2/3 3:51 下午
 * @version 0.0.1
 */
public class NanoCalculate implements Calculate {

    @Override
    public int add(int numA, int numB) {
        System.out.println("执行目标方法[add].");
        return numA + numB;
    }

    @Override
    public int sub(int numA, int numB) {
        return numA - numB;
    }

    @Override
    public int div(int numA, int numB) {
        return numA / numB;
    }

    @Override
    public int multi(int numA, int numB) {
        System.out.println("执行目标方法[multi].");
        //add(numA, numB);
        ((Calculate) AopContext.currentProxy()).add(numA, numB);
        return numA * numB;
    }
}
