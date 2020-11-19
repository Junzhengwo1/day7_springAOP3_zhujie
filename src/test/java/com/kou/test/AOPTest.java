package com.kou.test;

import com.kou.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author JIAJUN KOU
 */
public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=(IAccountService) ac.getBean("accountService");
        as.saveAccount();

    }
}
