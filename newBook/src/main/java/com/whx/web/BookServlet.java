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
public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int noPage = WebUtils.parseStringToInteger(req.getParameter("noPage"), 1);
        int pageSize = WebUtils.parseStringToInteger(req.getParameter("pageSize"), 4);

        Page<Book> page =  bookService.page(noPage , pageSize);

        req.setAttribute("page", page);

        page.setUrl("manager/bookServlet?action=page");

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }



    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> books = bookService.showAllBook();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());

        if( bookService.addBook(book) != -1 ){
            // req.getRequestDispatcher("/manager/bookServlet?action=page").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
        }else {
            req.setAttribute("msg", "图书添加失败");
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");

        }


    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseStringToInteger(req.getParameter("id"), 0);

        if(bookService.deleteBook(id)!=-1){
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
        }else {
            req.setAttribute("msg", "图书添加失败");
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
        }


    }

    protected void getBookInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id1 = req.getParameter("id");
        int id = WebUtils.parseStringToInteger(id1, 0);
        Book book = bookService.showBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);

    }


    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.ModifyBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&noPage="+req.getParameter("noPage"));

    }





}
