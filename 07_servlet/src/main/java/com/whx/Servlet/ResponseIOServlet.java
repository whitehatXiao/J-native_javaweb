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
 * @descriptions
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("你正在访问  ResponseIOServlet");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.write("你好啊, " + req.getParameter("username"));


        System.out.println(resp);

    }
}
