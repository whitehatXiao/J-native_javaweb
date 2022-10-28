package com.whx.dao;

import com.whx.pojo.Book;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/4
 * @descriptions
 */
public interface BookDao {


    public List<Book> queryAllBook();

    public int addBook(Book book);

    public  int modifyBook(Book book  );

    public int deleteBook( Integer id );

    public Book queryBookById(Integer id);

    public int getTotalCount();

    public List<Book> getBookItems(int begin , int pageSize);

    public int getPageTotalCountByPrice(int min, int max);

    public List<Book> getItemsByPrice(int begin, int pageSize, int min, int max);

}
