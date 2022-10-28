package com.whx.dao;

import com.whx.pojo.Book;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/9/25
 * @descriptions  接口规范 Book
 */
public interface BookDao {

    /**
     *
     * @param book
     * @return
     */
    public int addBook(Book book);


    /**
     *
     * @param id
     * @return
     */
    public int deleteBook(Integer id);


    /**
     *
     * @param book
     * @return
     */
    public int updateBook(Book book);

    /**
     *
     * @param id
     * @return
     */
    public Book QueryBookById(Integer id );


    /**
     *
     * @return
     */
    public List<Book> QueryBooks();

    public int getPageTotal(int pageSize);

    public int getPageTotalCount();

    public List<Book> getItems(int begin ,int  pageSize);

    public int getPageTotalCountByPrice(int min, int max);

    public List<Book> getItemsByPrice(int begin, int pageSize, int min, int max);
}
