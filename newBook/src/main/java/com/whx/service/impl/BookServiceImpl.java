package com.whx.service.impl;

import com.whx.dao.BookDao;
import com.whx.dao.impl.BookDaoImpl;
import com.whx.pojo.Book;
import com.whx.pojo.Page;
import com.whx.service.BookService;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/4
 * @descriptions
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> showAllBook() {
        return bookDao.queryAllBook();
    }

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int ModifyBook(Book book) {
        return bookDao.modifyBook(book);
    }

    @Override
    public int deleteBook(Integer id) {
        return bookDao.deleteBook(id);
    }

    @Override
    public Book showBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public Page<Book> page(int noPage, int pageSize) {

        int totalCount = bookDao.getTotalCount();
        int totalPageCount = totalCount / pageSize ;
        if( totalPageCount % pageSize != 0){
            totalPageCount+=1;
        }
        int begin = (noPage - 1 ) * pageSize ;

        List<Book> books =  bookDao.getBookItems(begin , pageSize);

        return  new Page<Book>(books, totalCount, pageSize, totalPageCount, noPage);


    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {

        Page<Book> bookPage = new Page<>();
        bookPage.setnoPage(pageNo);
        bookPage.setPageSize(pageSize);

        // pageTotalCount 总记录数
        int pageTotalCount = bookDao.getPageTotalCountByPrice(min,max);

        int pageTotal = pageTotalCount / pageSize;
        if(  pageTotalCount % pageSize > 0 ){
            pageTotal++;
        }

        bookPage.setTotalCount(pageTotal);
        bookPage.setTotalPageCount(pageTotalCount);

        int begin = (pageNo - 1 ) * pageSize;

        List<Book> items = bookDao.getItemsByPrice(begin, pageSize , min, max);

        bookPage.setBookItems(items);

        return  bookPage;

    }
}
