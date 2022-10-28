package com.whx.test;

import com.whx.dao.impl.BaseDao;
import com.whx.pojo.Book;
import com.whx.pojo.Page;
import com.whx.service.BookService;
import com.whx.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/9/26
 * @descriptions
 */
public class BookServiceImplTest extends BaseDao {

    BookService bs = new BookServiceImpl();

    @Test
    public void  page() {

        System.out.println(bs.page(1, 6) );
    }


    @Test
    public void pageByPrice() {
        System.out.println(bs.pageByPrice(1, 4, 10, 100));
    }

}