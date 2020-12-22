package javaweb2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/caoliduo?serverTimezone=UTC","root","cao894871274");
            Statement st=c.createStatement();
            String s1="update employ set payment=payment+100 where name='草多多'";
            st.executeUpdate(s1);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
