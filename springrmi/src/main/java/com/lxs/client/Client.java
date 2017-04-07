package com.lxs.client;

import com.lxs.server.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by carry on 17-1-3.
 */
public class Client extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("client.xml");
        AccountService accountService = (AccountService) ctx.getBean("mobileAccountService");
        String result = accountService.shoopingPayment("15691851953", (byte) 5);
        System.out.println(result);
    }
}
