package com.whx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WhitehatXiao
 * @date 2022/9/18
 * @descriptions 通过继承Servleet的实现类HttpServlet来实现功能
 */
public class HelloServlet2 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问 HelloServlet2 的 doGet方法");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("访问 HelloServlet2 的 doPost方法");

    }
}
