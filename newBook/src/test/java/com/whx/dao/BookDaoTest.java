package com.whx.dao;

import com.whx.dao.impl.BookDaoImpl;
import com.whx.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/10/4
 * @descriptions
 */
public class BookDaoTest {

    BookDao bookDao = new BookDaoImpl();
    @Test
    public void queryAllBook() {
        System.out.println(bookDao.queryAllBook());
    }

    @Test
    public void addBook() {
        System.out.println(bookDao.addBook(new Book(null, "武林外抓", new BigDecimal(100), "林", 10, 30, null)));
    }

    @Test
    public void modifyBook() {
        System.out.println(bookDao.modifyBook(new Book(10, "时间简史", new BigDecimal(100), "霍金", 100, 20, null)));
    }

    @Test
    public void deleteBook() {
        System.out.println(bookDao.deleteBook(10));
    }

    @Test
    public void getTotalCount(){
        System.out.println(bookDao.getTotalCount());
    }
    @Test
    public void getBookItems(){
        System.out.println(bookDao.getBookItems(1, 4));
    }


}