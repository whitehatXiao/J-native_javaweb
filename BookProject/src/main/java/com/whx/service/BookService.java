package com.whx.service;

import com.whx.pojo.Book;
import com.whx.pojo.Page;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/9/25
 * @descriptions
 */
public interface BookService {

    /**
     *
     * @param book
     */
    public void addBook(Book book);


    /**
     *
     * @param id
     */
    public void deleteBook(Integer id );

    /**
     *
     * @param book
     */
    public void updateBook(Book book);

    /**
     *
     * @return
     */
    public List<Book> queryBook();

    /**
     *
     * @param id
     * @return
     */
    public Book queryBookByid(Integer id);

    public Page<Book> page(int pageNo , int pageSize);


    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
