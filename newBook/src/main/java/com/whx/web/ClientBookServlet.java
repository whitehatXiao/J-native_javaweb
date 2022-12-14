package com.whx.web;

import com.whx.pojo.Book;
import com.whx.pojo.Page;
import com.whx.service.BookService;
import com.whx.service.impl.BookServiceImpl;
import com.whx.utils.WebUtils;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/4
 * @descriptions
 */
public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int noPage = WebUtils.parseStringToInteger(req.getParameter("noPage"), 1);
        int pageSize = WebUtils.parseStringToInteger(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page =  bookService.page(noPage , pageSize);

        page.setUrl("client/bookServlet?action=page");

        req.setAttribute("page", page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }



    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.parseStringToInteger(req.getParameter("noPage"), 1);
        int pageSize = WebUtils.parseStringToInteger(req.getParameter("pageSize"),Page.PAGE_SIZE);

        int min = WebUtils.parseStringToInteger(req.getParameter("min"), 0);
        int max = WebUtils.parseStringToInteger(req.getParameter("max"), Integer.MAX_VALUE);

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
