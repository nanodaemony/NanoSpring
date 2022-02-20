/**
 * @(#)LoginServiceImpl.java, 1月 22, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nano.service.impl;

import com.nano.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author chenzeng
 * @date 2022/1/22 11:00 下午
 * @version 0.0.1
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean userLogin(int userId) {
        System.out.println("User login now: " + userId);
        return true;
    }
}