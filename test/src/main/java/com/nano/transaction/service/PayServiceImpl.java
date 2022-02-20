package com.nano.transaction.service;

import com.nano.transaction.dao.AccountInfoDao;
import com.nano.transaction.dao.ProductInfoDao;
import java.math.BigDecimal;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by smlz on 2019/6/17.
 */
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private AccountInfoDao accountInfoDao;

    @Autowired
    private ProductInfoDao productInfoDao;


    @Override
    @Transactional(rollbackFor = RuntimeException.class, isolation = Isolation.DEFAULT)
    public void pay(String accountId, double money) {
        // 查询余额
        double blance = accountInfoDao.qryBlanceByUserId(accountId);

        // 更新库存
        ((PayService) AopContext.currentProxy()).updateProductStore(1);

        // 更新余额
        int retVal = accountInfoDao.updateAccountBlance(accountId, money);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = RuntimeException.class)
    public void updateProductStore(Integer productId) {
        try {
            productInfoDao.updateProductInfo(productId);

        } catch (Exception e) {
            throw new RuntimeException("更新库存异常");
        }
    }

}
