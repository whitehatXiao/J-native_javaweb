package com.whx.web;

import com.whx.pojo.Book;
import com.whx.pojo.Page;
import com.whx.service.BookService;
import com.whx.service.impl.BookServiceImpl;
import com.whx.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WhitehatXiao
 * @date 2022/9/26
 * @descriptions
 */
public class ClientBookServlet extends  BaseServlet{


    private BookService bookService = new BookServiceImpl();


    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // bookServlet
        //         page
        // 1、获取请求的参数 pageNo , pageSize
        // 2、调用bookservice获取pageTotal、pagatotalcount、items
        // 3、设置到 request域中
        // 4、请求转发到 /pages/manager/book_manager.jsp

        // System.out.println("经过了前台的ClientBookServletc层序");


        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);


        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("client/bookServlet?action=page");

        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }



    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"),Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min , max );

        StringBuilder stringBuilder = new StringBuilder("client/bookServlet?action=pageByPrice");
        if( req.getParameter("min") != null )
            stringBuilder.append("&min=").append(req.getParameter("min"));
        if( req.getParameter("max") != null)
            stringBuilder.append("&max=").append(req.getParameter("max"));

        page.setUrl(stringBuilder.toString());

        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

}
