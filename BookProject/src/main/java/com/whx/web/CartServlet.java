package com.whx.web;

import com.google.gson.Gson;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WhitehatXiao
 * @date 2022/9/29
 * @descriptions
 */


public class CartServlet  extends BaseServlet {

    private BookService bookService = new BookServiceImpl();


    /**
     *  用 ajax技术来局部更新，添加商品到购物车这种小操作并不需要更新整个页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
// 调用 bookService.queryBookById(id):Book 得到图书的信息
        Book book = bookService.queryBookByid(id);
// 把图书信息，转换成为 CartItem 商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
// 调用 Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            // 很合乎常理，如果 Cart cart = new Cart() 这么写就相当于没购入一件商品就换一辆购物车 ， 所以购物车中最多也只有一个
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        String lastName = cartItem.getName();

        // 最后一个添加的商品名称
        req.getSession().setAttribute("lastName", lastName);

        Integer cartTotalCount = cart.getTotalCount();

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("cartTotalCount", cartTotalCount);
        resultMap.put("lastName", lastName);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);

    }

    /**
     * 加入购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
// 调用 bookService.queryBookById(id):Book 得到图书的信息
        Book book = bookService.queryBookByid(id);
// 把图书信息，转换成为 CartItem 商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
// 调用 Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            // 很合乎常理，如果 Cart cart = new Cart() 这么写就相当于没购入一件商品就换一辆购物车 ， 所以购物车中最多也只有一个
            cart = new Cart();
                req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        // 最后一个添加的商品名称
        req.getSession().setAttribute("lastName", cartItem.getName());
        // System.out.println(cart);
        // System.out.println("请求头 Referer 的值：" + req.getHeader("Referer"));
// 重定向回原来商品所在的地址页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException{
// 获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
// 获取购物车对象
//       感觉有个问题， 这里执行删除cart里面对象以后，不需要在重新把 cart 对象 setArribute() 回Sesion字段码？？
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
// 删除 了购物车商品项
            cart.deleteItem(id);
// 重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException{
// 1 获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
// 清空购物车   ，  那么应该就是删除cart对象就会影响到httpheader中的session域了，不需要手动操作放回
            cart.clear();
// 重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException{
// 获取请求的参数 商品编号 、商品数量
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
// 获取 Cart 购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
// 修改商品数量
            cart.updateItem(id,count);
// 重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }



}
