package com.whx.service.impl;

import com.whx.dao.BookDao;
import com.whx.dao.impl.BookDaoImpl;
import com.whx.pojo.Book;
import com.whx.pojo.Page;
import com.whx.service.BookService;
import com.whx.utils.WebUtils;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/9/25
 * @descriptions
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public List<Book> queryBook() {
        return bookDao.QueryBooks();
    }

    @Override
    public Book queryBookByid(Integer id) {
        return bookDao.QueryBookById(id);
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        // 泛型的正确使用方法，容器
        Page<Book> bookPage = new Page<>();
        bookPage.setPageNo(pageNo);
        bookPage.setPageSize(pageSize);


        int pageTotalCount = bookDao.getPageTotalCount();

        int pageTotal = pageTotalCount / pageSize;
        if(  pageTotalCount % pageSize > 0 ){
            pageTotal++;
        }

        bookPage.setPageTotal(pageTotal);
        bookPage.setPageTotalCount(pageTotalCount);

        int begin = (pageNo - 1 ) * pageSize;

        List<Book> items = bookDao.getItems(begin, pageSize);
        bookPage.setItems(items);
        return  bookPage;

    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> bookPage = new Page<>();
        bookPage.setPageNo(pageNo);
        bookPage.setPageSize(pageSize);

        // pageTotalCount 总记录数
        int pageTotalCount = bookDao.getPageTotalCountByPrice(min,max);

        int pageTotal = pageTotalCount / pageSize;
        if(  pageTotalCount % pageSize > 0 ){
            pageTotal++;
        }

        bookPage.setPageTotal(pageTotal);
        bookPage.setPageTotalCount(pageTotalCount);

        int begin = (pageNo - 1 ) * pageSize;

        List<Book> items = bookDao.getItemsByPrice(begin, pageSize , min, max);

        bookPage.setItems(items);

        return  bookPage;

    }


}
