package com.lxs.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by carry on 17-1-3.
 */
public class RmiServer {
    public static void main(String[] args) throws InterruptedException {
        new ClassPathXmlApplicationContext("server.xml");

        Object lock = new Object();
        synchronized (lock) {
            lock.wait();
        }
    }
}
