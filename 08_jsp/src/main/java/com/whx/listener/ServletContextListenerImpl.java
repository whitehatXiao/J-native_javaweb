package com.whx.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author WhitehatXiao
 * @date 2022/9/22
 * @descriptions
 */
public class ServletContextListenerImpl implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(" ServletContext 对象被创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext 对象被销毁");
    }
}
