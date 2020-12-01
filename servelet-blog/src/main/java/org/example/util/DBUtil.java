package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-29
 * Time: 16:36
 **/
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/servlet_blog?user=root&password=261919Zss&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static final DataSource DS = new MysqlDataSource();
    static {
        ((MysqlDataSource) DS).setUrl(URL);
    }
    public static Connection getConnection(){
        try {
            return DS.getConnection();
        } catch (SQLException e) {

            throw new AppException("获取数据库连接失败",e);
        }
    }
}
