package com.nuist.dao;

import com.nuist.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDao<T> {

    private QueryRunner qr = new QueryRunner();

    //执行insert, update, delete语句
    public int update(String sql, Object... params) {
        Connection conn = DBUtils.getConnection();
        try {
            return qr.update(conn, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //返回多行数据
    public List<T> queryMulti(String sql, Class<T> clazz, Object... params){
        Connection conn = DBUtils.getConnection();
        try {
            return qr.query(conn, sql, new BeanListHandler<T>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //返回单行数据
    public T querySingle(String sql, Class<T> clazz, Object... params){
        Connection conn = DBUtils.getConnection();
        try {
            return qr.query(conn, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //返回单行单列的数据
    public Object queryScalar(String sql, Object... params){
        Connection conn = DBUtils.getConnection();
        try {
            return qr.query(conn, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
