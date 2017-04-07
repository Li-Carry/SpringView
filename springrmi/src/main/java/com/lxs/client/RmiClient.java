package com.lxs.client;

import com.lxs.server.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by carry on 17-1-3.
 */
public class RmiClient {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("client.xml");
        AccountService accountService = (AccountService) ctx.getBean("mobileAccountService");
        String result = accountService.shoopingPayment("15691851953", (byte) 5);
        System.out.println(result);
    }
}
