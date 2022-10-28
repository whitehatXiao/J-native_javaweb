package com.whx.dao.impl;

import com.whx.dao.BookDao;
import com.whx.pojo.Book;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/9/25
 * @descriptions
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    // private BaseDao bd = new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`)  values(?,?,?,?,?,?)" ;
        return update(sql, book.getName(), book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBook(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`= ?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id=?";
        return update(sql, book.getName(), book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book QueryBookById(Integer id) {
        String sql = "select id,name,author,price,sales,stock,img_path as ImagePath from t_book where id=?";
        return queryForOne(Book.class, sql, id);

    }

    @Override
    public List<Book> QueryBooks() {
        String sql = "select id,name,author,price,sales,stock,img_path as ImagePath from t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public int getPageTotal(int pageSize) {
        int totalPage =  getPageTotalCount() / pageSize ;
        if(getPageTotalCount() % pageSize > 0 ){
            totalPage++;
        }
        return totalPage;
    }

    @Override
    public int getPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number number = (Number)queryForSingleValue(sql);
        return number.intValue();
    }

    @Override
    public List<Book> getItems(int begin ,int  pageSize) {
        String sql = "select id,name,author,price,sales,stock,img_path as ImagePath from t_book limit ?,?";
        List<Book> books = queryForList(Book.class, sql, begin, pageSize);
        return books;
    }



    @Override
    public int getPageTotalCountByPrice(int min, int max) {
        // String sql = " select count(*) from t_book between ? , ? ";
        String sql = "select count(*) from t_book where price between ? and ?";
        Number o = (Number) queryForSingleValue(sql, min, max);
        return o.intValue();
    }

    @Override
    public List<Book> getItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select id,name,author,price,sales,stock,img_path as ImagePath from t_book  " +
                "where price between ? and ? order by price limit ?,?";
        List<Book> books = queryForList(Book.class, sql,min, max , begin, pageSize);
        return books;
    }
}
