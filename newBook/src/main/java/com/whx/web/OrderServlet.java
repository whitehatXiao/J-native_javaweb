package com.whx.web;

import com.whx.pojo.Cart;
import com.whx.pojo.Order;
import com.whx.pojo.OrderItem;
import com.whx.pojo.User;
import com.whx.service.OrderService;
import com.whx.service.impl.OrderServiceImpl;
import com.whx.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart == null) {
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }

        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }

        String orderid = orderService.createOrder(cart, user.getId());

        req.getSession().setAttribute("orderid", orderid);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");

    }

    protected void showMyOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }

        // Map<Integer , Order> map = new LinkedHashMap<>();
        List<Order> orders = orderService.showMyOrders(user.getId());
        // for(int i = 0 ; i < orders.size() ; i++){
        //     map.put(i, orders.get(i));
        // }

        // System.out.println(orders);

        req.setAttribute("myorderlist", orders);

        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);

    }


    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String orderid = (String) req.getSession().getAttribute("orderid");
        if (orderid == null) {
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }

        List<OrderItem> orderDetail = orderService.showOrderDetail(orderid);

        req.setAttribute("orderDetail", orderDetail);

        req.getRequestDispatcher("/pages/order/showDetail.jsp").forward(req, resp);
    }

    protected void receiverOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String chooceOrderId = req.getParameter("chooceOrderId");
        int status = WebUtils.parseStringToInteger(req.getParameter("status"), 0);
        if (chooceOrderId == null) {
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }

        orderService.receiverOrder(chooceOrderId , status);

        resp.sendRedirect(req.getHeader("Referer"));
    }

}
