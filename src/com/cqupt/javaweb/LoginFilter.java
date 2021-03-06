package com.cqupt.javaweb;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆过滤器
 *
 * @author hetiantian
 * @version 2017/12/26.
 */
public class LoginFilter implements Filter {

    /**
     * web应用程序启动时调用此方法，用于初始化该Filter
     *
     * @param filterConfig 可以从参数中获取初始化参数以及ServletContext信息等
     * @throws ServletException
     * */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 拦截客户端的请求
     *
     * @param servletRequest 客户端的请求
     * @param servletResponse 服务端的响应
     * @param filterChain 传递请求给下一个filter
     * @throws ServletException
     * @throws IOException
     * */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse rep = (HttpServletResponse)servletResponse;

        //获取session对象
        HttpSession session = req.getSession();

        //从session对象中获取用户信息
        String name = (String)session.getAttribute("name");
        System.out.println("name: " + name);

        //如果没有登陆,此时session将取不到值,重定向到登录页面
        if (name == null || name.equals("")) {
            rep.sendRedirect("/login.html");
        } else {
            //如果已经登陆，继续此次请求
            //可以在这里做用户名和密码的验证
            filterChain.doFilter(req, rep);
        }
    }

    /**
     * web程序关闭时调用此方法，用于销毁一些资源
     * */
    @Override
    public void destroy() {

    }
}
