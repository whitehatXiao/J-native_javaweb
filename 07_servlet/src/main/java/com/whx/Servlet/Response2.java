package com.whx.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author WhitehatXiao
 * @date 2022/9/20
 * @description
 *  * @descriptions Response1 和 2 都是模拟重定向行为
 */
public class Response2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到重定向来访问 Response2 的请求");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("你已经重定向到当前 Response 2 了");
    }
}
