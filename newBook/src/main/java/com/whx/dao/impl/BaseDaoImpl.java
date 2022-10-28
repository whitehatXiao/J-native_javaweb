package com.whx.dao.impl;

import com.whx.dao.BaseDao;
import org.apache.commons.dbutils.QueryRunner;
import com.whx.utils.newDdbUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/3
 * @descriptions
 */
public abstract class BaseDaoImpl implements BaseDao {

    private QueryRunner queryRunner = new QueryRunner() ;

    @Override
    public int tSafeUpdate(String sql, Object... params) throws SQLException , RuntimeException{
            // 要在最顶层调用的事务处理，这里本质上还是原子操作，把异常逐层向上抛出
            return  queryRunner.update(newDdbUtils.getTsafeConnection(), sql, params);

    }

    @Override
    public int update(String sql, Object... params) {
        // 手段关闭流，queryRunner.update 并没有帮你关闭流
        Connection connection = newDdbUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1 ;
    }

    @Override
    public <T> T queryForOne(Class<T> clazz, String sql, Object... params) {
        Connection conn = newDdbUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public <T> List<T> queryForList(Class<T> clazz, String sql, Object... params) {
        Connection connection = newDdbUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return  null;
    }

    @Override
    public Object queryForSingleValue(String sql, Object... params) {
        Connection connection = newDdbUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return  null;
    }
}
