package javaweb2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcPractice {
    public static void main(String[] args)  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/caoliduo?serverTimezone=UTC","root","cao894871274");
            Statement s=c.createStatement();
            String s1="insert into employ values(1,'杜云帆','男',20,10000)";
            String s2="insert into employ values(2,'史江蓉','女',18,20000)";
            String s3="insert into employ values(3,'草多多','女',18,20000)";

            s.executeUpdate(s1);
            s.executeUpdate(s2);
            s.executeUpdate(s3);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
