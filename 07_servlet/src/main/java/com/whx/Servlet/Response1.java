package com.whx.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WhitehatXiao
 * @date 2022/9/20
 * @descriptions Response1 和 2 都是模拟重定向行为
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("客户端正在访问 Response1 !");
//        resp.setStatus(302);
//        resp.setHeader("location", "http://localhost:8080/07_Servlet/response2");

        // 来个更加简便的方法
        resp.sendRedirect("http://localhost:8080/07_Servlet/response2");

    }
}
