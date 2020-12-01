package org.example.servlet;

import org.example.exception.AppException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-29
 * Time: 16:33
 **/
@WebServlet("/login")
public class LoginServlet extends AbstractBaseServlet{
    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");


        if ("abc".equals(userName)){
            resp.sendRedirect("jsp/articleList.jsp");
        }else {
            throw new AppException("用户名密码错误");
        }
    }
}
