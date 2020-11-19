package com.kou.service.impl;

import com.kou.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @author JIAJUN KOU
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("保存......");

    }

    @Override
    public void updateAccount(Integer id) {
        System.out.println("更新。。。。。");
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除。。。。");
        return 0;
    }
}
