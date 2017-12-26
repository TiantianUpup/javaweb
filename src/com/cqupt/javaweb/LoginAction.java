package com.cqupt.javaweb;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 登陆控制中心
 *
 * @author hetiantian
 * @version  2017/12/26.
 */
public class LoginAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求分发正确");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        //将用户信息保存到session中
        request.getSession().setAttribute("name", name);
        request.getSession().setAttribute("password", password);

        //重定向到success_login.html页面中
        response.sendRedirect("/success_login.html?request");
    }
}
