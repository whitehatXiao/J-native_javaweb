package com.whx.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.whx.service.UserService;
import com.whx.service.impl.UserServiceImpl;


import com.whx.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.whx.utils.WebUtils;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;


/**
 * @author WhitehatXiao
 * @date 2022/9/25
 * @descriptions
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();


    /**
     *  ajax : Asynchronous JavaScript And Xml 是一种浏览器通过JS异步发起请求，局部更新页面的技术
     *  这里用来在注册页面是验证用户名是否可以使用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
// 获取请求的参数 username
        String username = req.getParameter("username");
// 调用 userService.existsUsername();
        boolean existsUsername = userService.existsUsername(username);
// 把返回的结果封装成为 map 对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }

    /**
     * 处理注销地功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 1、销毁 Session 中用户登录的信息（或者销毁 Session）
        req.getSession().invalidate();
// 2、重定向到首页（或登录页面）。
        System.out.println("getContextPath这个方法拿的是工程路径地文件名， 是不带 \\ 地把？？ " + req.getContextPath());
        resp.sendRedirect(req.getContextPath());
    }




    /**
     * 处理登录的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
// 1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
// 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User( username, password, null));

// 如果等于 null,说明登录 失败!
        if (loginUser == null) {
// 把错误信息，和回显的表单项信息，保存到 Request 域中
            req.setAttribute("msg","用户或密码错误！");
            req.setAttribute("username", username);
// 跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {

            // 将 loginUser对象写入到req地SessionScope域中，方便前台显示
            req.getSession().setAttribute("user", loginUser);
// 登录 成功
//跳到成功页面 login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
    /**
     * 处理注册的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        // 获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除 Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if (token!=null && token.equalsIgnoreCase(code)) {
//        3、检查 用户名是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在!");

                // 把回显信息，保存到Request域中
                req.setAttribute("msg", "用户名已存在！！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

//        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //      可用
//                调用Sservice保存到数据库
                userService.regisUser(new User(null, username, password, email));
//
//        跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            // 把回显信息，保存到Request域中
            req.setAttribute("msg", "验证码错误！！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }


    }

}

