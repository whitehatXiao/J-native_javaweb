package com.whx.test;

import com.whx.dao.BookDao;
import com.whx.dao.impl.BaseDao;
import com.whx.dao.impl.BookDaoImpl;
import com.whx.pojo.Book;
import com.whx.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/9/25
 * @descriptions 测试持久层 BookDaoImpl
 */
public class BookDaoTest extends BaseDao {

    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book("星际穿越", "汉季末", BigDecimal.valueOf(1011.35), 1000, 10, null));
    }

    @Test
    public void deleteBook() {
        bookDao.deleteBook(10);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(20, "呐喊", "鲁迅", BigDecimal.valueOf(98.99), 1000, 8, null));

    }

    @Test
    public void queryBookById() {
        Book book = bookDao.QueryBookById(21);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.QueryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void getPageTotal() {
        System.out.println(bookDao.getPageTotal(Page.PAGE_SIZE));
    }

    @Test
    public void getPageTotalCount() {
        System.out.println(bookDao.getPageTotalCount());
    }

    @Test
    public void getItems() {
        System.out.println(bookDao.getItems(1, 5));
    }


    @Test
    public void getPageTotalCountByPrice() {

        System.out.println(bookDao.getPageTotalCountByPrice(10 , 100 ));
    }

    @Test
    public void getItemsByPrice() {
        System.out.println(bookDao.getItemsByPrice(0, 4, 10, 100));
    }



}