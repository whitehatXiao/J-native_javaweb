package com.whx.ajax;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author WhitehatXiao
 * @date 2022/9/25
 * @descriptions  abstract :  a Struct of new Level
 *    需要注意， 前台 jsp 的还是将from表单提交到 UserServlet而不是 BaseServlet 的
 */
public abstract  class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        //解决post请求中文乱码问题，一定要在请求参数之前调用
        req.setCharacterEncoding("UTF-8");
        // 解决响应中文乱码
        resp.setContentType("text/html; charset=UTF-8");

        //  用反射来优化代码，以免写大量的 if else 判断语句

        String action = req.getParameter("action");
        try {
// 获取 action 业务鉴别字符串，获取相应的业务 方法反射对象
//            这样规定了反射得参数列表，就必要要求使用反射调用得函数都需要传入 req , resp
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class,
                    HttpServletResponse.class);
// System.out.println(method);
// 调用目标业务 方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
