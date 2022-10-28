package com.whx.web;

import com.whx.pojo.Book;
import com.whx.pojo.Cart;
import com.whx.pojo.CartItem;
import com.whx.service.BookService;
import com.whx.service.impl.BookServiceImpl;
import com.whx.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class CartServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseStringToInteger(req.getParameter("id"), 0);

        Book book = bookService.showBookById(id);

        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        req.getSession().setAttribute("lastName", book.getName());
        req.getSession().setAttribute("cartTotalCount",cart.getTotalCount());
        cart.addItem(cartItem);

        resp.sendRedirect(req.getHeader("Referer"));

    }


    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseStringToInteger(req.getParameter("id"), -1);
        String referer = req.getHeader("Referer");
        if(id==-1) resp.sendRedirect(referer);

        Cart cart =(Cart) req.getSession().getAttribute("cart");

        if(cart!=null) {
            cart.deleteItem(id);
            resp.sendRedirect(referer);
        }
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String referer = req.getHeader("Referer");
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.clear();
            resp.sendRedirect(referer);
        }

    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseStringToInteger(req.getParameter("id"), 0);
        int count = WebUtils.parseStringToInteger(req.getParameter("count"), 1);

        System.out.println("Referer :" + req.getHeader("Referer") );

        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart != null){
            cart.updateCount(id, count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
