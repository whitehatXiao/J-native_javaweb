package com.whx.web;

import com.whx.dao.BookDao;
import com.whx.dao.impl.BookDaoImpl;
import com.whx.pojo.Book;
import com.whx.pojo.Page;
import com.whx.service.BookService;
import com.whx.service.impl.BookServiceImpl;
import com.whx.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/9/25
 * @descriptions
 */
public class BookServlet extends BaseServlet{

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

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("manager/bookServlet?action=page");

        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }


    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo+=1;
        //        1、获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
//        2、调用BookService.addBook()保存图书
        bookService.addBook(book);
//        3、跳到图书列表页面
//                /manager/bookServlet?action=list
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 1、获取请求的参数 id，图书编程
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
// 2、调用 bookService.deleteBookById();删除图书
        bookService.deleteBook(id);
// 3、重定向回图书列表管理页面
// /book/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

// 1、获取请求的参数==封装成为 Book 对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
// 2、调用 BookService.updateBook( book );修改图书
        bookService.updateBook(book);
// 3、重定向回图书列表管理页面
// 地址：/工程名/manager/bookServlet?action=list
//        是只有 HttpRequestServlet req 中的 getDispatcherPath.forward() 才会被服务器解析 “/” 为工程路劲吗？？
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
    }


    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1、 通过BookService查询全部图书
        // 2、 把全部图书保存到Request域中
        // 3、 请求转发到 /pages/manager/book_manager.jsp

        List<Book> books = bookService.queryBook();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }


    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1 获取请求的参数图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
//2 调用 bookService.queryBookById 查询图书
        Book book = bookService.queryBookByid(id);
//3 保存到图书到 Request 域中
        req.setAttribute("book", book) ;
//4 请求转发到。pages/manager/book_edit.jsp 页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

    }




}
