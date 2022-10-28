package com.whx.servlet;
/**
 * @author WhitehatXiao
 * @date 2022/9/18
 * @descriptions  使用 idea 快速生产 servlet3 ，还需要手动填写 web.xml中的地址信息
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问 HelloServlet3 的 doget");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问 HelloServlet3 的 dopost");

    }
}
