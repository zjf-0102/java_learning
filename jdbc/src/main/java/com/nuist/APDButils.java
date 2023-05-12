package com.nuist;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 使用apache提供的工具类来对查询到的结果进行封装
 */
@SuppressWarnings("all")
public class APDButils {

    @Test
    public void testAPDBUtils() {
        //先获取连接
        Connection connection = DButils.getConnection();
        //再进行数据库操作
        String sql = "select * from actor where id >= ?";
        try {
            QueryRunner queryRunner = new QueryRunner();
            /*
            第一个参数：连接
            第二个参数：sql语句
            第三个参数：封装方法
            第四个参数：sql语句中的缺省值
             */
            List<Actor> actorList = queryRunner.query(connection, sql, new BeanListHandler<Actor>(Actor.class), 2);
            for (Actor actor : actorList) {
                System.out.println(actor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //关闭资源，apache的工具类底层会自动关闭 结果集 和 preparedStatement
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
