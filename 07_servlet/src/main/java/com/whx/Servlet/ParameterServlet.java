package com.whx.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author WhitehatXiao
 * @date 2022/9/19
 * @descriptions
 */
public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("测试一下，中文输出是否乱码！！！");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");

        System.out.println("access username : "+username);
        System.out.println("access password : "+password);

//        for (String hobby : hobbies) {
//            System.out.println("hobby" + hobby);
//        }

        //
        /*
        *     public static String toString(long[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
        * */

        // Arrays.asList 中，或者说 Arraylist 重写了 tostring()方法
        System.out.println(Arrays.asList(hobbies));

    }
}
