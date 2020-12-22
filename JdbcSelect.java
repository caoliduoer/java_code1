package javaweb2;

import java.sql.*;

public class JdbcSelect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/caoliduo?serverTimezone=UTC","root","cao894871274");
            Statement s=c.createStatement();
            String s1="select * from employ";
            ResultSet rs=s.executeQuery(s1);
            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String sex=rs.getString("sex");
                int age=rs.getInt("age");
                int payment=rs.getInt("payment");
                System.out.println(id+"       "+name+"       "+sex+"       "+age+"       "+payment);
            }
        } catch (ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }
    }
}
