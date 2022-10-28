package com.whx.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WhitehatXiao
 * @date 2022/9/20
 * @descriptions 模拟请求转发
 */
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");

        String key = (String)req.getAttribute("key");

        System.out.println(key);
        System.out.println("处理 Servlet2 的任务");
    }
}
