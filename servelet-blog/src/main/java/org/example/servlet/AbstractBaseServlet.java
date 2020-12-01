package org.example.servlet;

import org.example.exception.AppException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-29
 * Time: 16:07
 **/
public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html");
            //Session会话管理：除登录和注册接口，其他都需要登陆后访问
            //通过req.getServletPath()获取请求访问路径
            //TODO
            //调用子类重写的方法
            process(req, resp);
        }catch (Exception e){
            //异常处理 JDBC异常，Jason处理异常，用户名不存在，密码错误
            e.printStackTrace();
            String str = "未知错误";
            if (e instanceof AppException){
                str =  e.getMessage();
            }
            PrintWriter pw = resp.getWriter();
            pw.println(str);
            pw.flush();
            pw.close();


        }
    }
    protected abstract void process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
