package com.whx.service;

import com.whx.pojo.Book;
import com.whx.pojo.Page;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/4
 * @descriptions
 */
public interface BookService {

    public List<Book> showAllBook();

    public int addBook(Book book);

    public int ModifyBook(Book book);

    public int deleteBook(Integer id);

    public Book showBookById(Integer id );

    public Page<Book> page(int noPage , int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);




}
