package javaweb2;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/caoliduo?serverTimezone=UTC","root","cao894871274");
            Statement s=c.createStatement();
            String s2="insert into employ values(3,'duoer','女',22,7800)";
            String s3="insert into employ values(4,'张三','男',60,42000)";
            String s4="update employ set payment=payment+(0.5*payment) where age>45";
            String s5="update employ set payment=payment+(0.1*payment) where age<=45";
            String s7="delete from employ where payment>1500";
            s.executeUpdate(s2);
            s.executeUpdate(s3);
            s.executeUpdate(s4);
            s.executeUpdate(s5);
            s.executeUpdate(s7);
          // String s1="delete from employ where name='duoer' or  name='张三'";
           String s6="select *from employ order by payment desc";
           // s.executeUpdate(s1);
            //s.executeUpdate(s6);
            ResultSet rs=s.executeQuery(s6);
            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String sex=rs.getString("sex");
                int age=rs.getInt("age");
                int payment=rs.getInt("payment");
                System.out.println(id+"      "+name+"      "+sex+"         "+age+"       "+payment);
            }
            s.close();
            c.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
