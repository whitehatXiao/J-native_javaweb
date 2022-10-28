package com.whx.web;

import com.whx.pojo.Cart;
import com.whx.pojo.User;
import com.whx.service.BookService;
import com.whx.service.OrderService;
import com.whx.service.impl.BookServiceImpl;
import com.whx.service.impl.OrderServiceImpl;
import com.whx.utils.DdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WhitehatXiao
 * @date 2022/9/29
 * @descriptions 订单Web模块
 */
public class OrderServlet extends BaseServlet{

    private OrderService orderService = new OrderServiceImpl() ;

    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        // System.out.println("createOrder程序正在["+Thread.currentThread().getName()+"]中");

    // 先获取 Cart 购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
    // 获取 Userid
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = loginUser.getId();
    // 调用 orderService.createOrder(Cart,Userid);生成订单

        String orderId = null ;

        try {
            orderId  = orderService.createOrder(cart, userId);



            DdbcUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            DdbcUtils.rollbackAndClose();
        }


        // req.setAttribute("orderId", orderId);
    // 请求转发到/pages/cart/checkout.jsp
    // req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);

        // 要注意的是，如果选择的是重定向的方式，是不可以使用 RequestScope的数据的，
        // 此时大概只能放入到 SessionScope 当中去了
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }



}


