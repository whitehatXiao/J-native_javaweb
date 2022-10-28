package com.whx.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author WhitehatXiao
 * @date 2022/9/18
 * @descriptions Servlet 初入门
 */
public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("执行Servlet构造器放啊");
        System.out.println("执行init初始化方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.println("hello Servlet !!! ");
//        System.out.println("Servlet 被访问了 ！！！ ");
        System.out.println( "3  HelloServlet 被访问了");

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest ;
        String method = httpServletRequest.getMethod();
        if( "GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }
    }

    public void doGet(){
        System.out.println("执行Get方法");

    }

    public void doPost(){
        System.out.println("执行Post方法");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destory方法被调用");
    }
}
