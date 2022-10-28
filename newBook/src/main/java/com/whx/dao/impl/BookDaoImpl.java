package com.whx.dao.impl;

import com.whx.dao.BaseDao;
import com.whx.dao.BookDao;
import com.whx.pojo.Book;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/4
 * @descriptions
 */
public class BookDaoImpl extends BaseDaoImpl implements BookDao {

    // bug复现
    // private BaseDao baseDao = new BookDaoImpl();

    @Override
    public List<Book> queryAllBook() {
        String sql = "select * from t_book";
        return  queryForList(Book.class, sql);
    }

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) " +
                "values(?,?,?,?,?,?,?)";
        return update(sql, book.getId(),book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public int modifyBook(Book book) {
        String sql = "update t_book set `name`=? , `author`=? , `price`=?, `sales`=?, `stock`=?, `img_path`=? where `id`=? ";
        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public int deleteBook(Integer id) {
        String sql = "delete from t_book where id=?";
        return update(sql, id);
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from t_book ";
        Number o = (Number)queryForSingleValue(sql);
        return o.intValue();
    }

    @Override
    public List<Book> getBookItems(int begin, int pageSize) {
        String sql = "select * from t_book limit ? , ?  ";
        return queryForList(Book.class, sql, begin , pageSize);
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
        String sql = "select * from t_book where price between ? and ? order by price limit ?,?";
        List<Book> books = queryForList(Book.class, sql,min, max , begin, pageSize);
        return books;
    }


}
