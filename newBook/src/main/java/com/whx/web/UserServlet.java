package com.whx.web;

import com.whx.pojo.User;
import com.whx.service.UserService;
import com.whx.service.impl.UserServiceImpl;
import com.whx.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;
import com.google.code.kaptcha.*;

/**
 * @author WhitehatXiao
 * @date 2022/10/3
 * @descriptions
 */
public class UserServlet extends BaseServlet{

    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser =  userService.checkUser(username , password);


        if( loginUser != null){

            req.getSession().setAttribute("user",loginUser);

            req.setAttribute("msg", "【"+username+"】登陆成功！");
            req.setAttribute("username", username);
            // 用户名匹配
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);

        }else {
            // resp.getWriter().write("用户名或密码错误!");
            req.setAttribute("msg", "用户名或密码错误!");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }

    }


    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }


    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        String token = (String)  req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        if(token.equalsIgnoreCase(code)){
            User Cuser = userService.ExistUsername(username);
            if(Cuser == null){
                if(userService.registUser(user) != -1)
                    // System.out.println("用户【"+username+"】已注册成功");
                resp.sendRedirect(req.getContextPath() + "/pages/user/regist_success.jsp");
            }else {
                // resp.getWriter().write("用户名已存在");
                resp.sendRedirect(req.getContextPath() + "/pages/user/regist.jspjsp");

            }

        }else {
            req.setAttribute("username",username);
            req.setAttribute("email", email);
            // resp.getWriter().write("验证码输入错误！");
            resp.sendRedirect(req.getContextPath() + "/pages/user/regist.jspjsp");
        }


    }

    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
