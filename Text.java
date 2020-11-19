package frank.jdbc.text;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Text {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSst=null;
        List<emp> list=new ArrayList<>();
        try {
            // 加载JDBC驱动程序：反射，这样调用初始化com.mysql.jdbc.Driver类，即将该类加载到JVM方法区，并执行该类的静态方法块、静态属性。
            Class.forName("com.mysql.jdbc.Driver");

            // 创建数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/caoliduo?user=root&password=cao894871274&useUnicode=true&characterEncoding=UTF-8");
            System.out.println(connection);
            //创建操作命令对象
            statement=connection.createStatement();
            //执行sql语句；
            String sql="select id,sn,name,qq_mail,classes_id from student";
            resultSst=statement.executeQuery(sql);
            //打印结果集；
            while(resultSst.next()){//看结果集有没有下一行，有的话直接跳转到下一行。
                int id=resultSst.getInt("id");
                String sn=resultSst.getString("sn");
                String name=resultSst.getString("name");
                String qq_mail=resultSst.getString("qq_mail");
                int class_id=resultSst.getInt("classes_id");
                emp emp=new emp();
                emp.setId(id);
                emp.setSn(sn);
                emp.setName(name);
                emp.setQq_emil(qq_mail);
                emp.setClass_id(class_id);
                list.add(emp);
                System.out.printf("id=%s,sn=%s,name=%s,qq_mail=%s,class_id=%s\n",emp.id,emp.sn,emp.name,emp.qq_emil,emp.class_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(resultSst!=null){
                    resultSst.close();
                }
                if(statement!=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //释放资源

    } private static class emp{
        private int id;
        private String sn;
        private String name;
        private String qq_emil;
        private int class_id;

        public int getId() {//得到属性的值
            return id;
        }

        public void setId(int id) {//为属性设置值
            this.id = id;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getQq_emil() {
            return qq_emil;
        }

        public void setQq_emil(String qq_emil) {
            this.qq_emil = qq_emil;
        }

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }
    }
}
