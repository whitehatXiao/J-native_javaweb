package com.whx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WhitehatXiao
 * @date 2022/9/27
 * @descriptions
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if( "lin".equals(username) && "whitehat".equals(password)){
            System.out.println("登陆 成功");
            Cookie loginCookie = new Cookie("username", username);
            loginCookie.setMaxAge( 60 * 60 * 24 *  7 );
            resp.addCookie(loginCookie);

        }else{
            System.out.println("登陆 失败");

        }

    }
}
