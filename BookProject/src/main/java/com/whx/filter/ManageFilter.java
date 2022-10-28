package com.whx.filter;

import com.whx.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author WhitehatXiao
 * @date 2022/9/30
 * @descriptions 对 web 工程下的 manage 目录过滤
 */
public class ManageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain
            filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Object user = httpServletRequest.getSession().getAttribute("user");


        if (user == null) {
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
