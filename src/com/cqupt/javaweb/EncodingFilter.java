package com.cqupt.javaweb;


import javax.servlet.*;
import java.io.IOException;

/**
 * 编码过滤器,在request提交到servlet之前对request进行指定的编码方式
 *
 * @author hetiantian
 * @version 2017/12/26.
 */
public class EncodingFilter implements Filter {
    private String characterEncoding;  //编码方式,配置在web.xml中
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化编码方式
        characterEncoding = filterConfig.getInitParameter("characterEncoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         //设置request，response的编码方式
        if (characterEncoding != null) {
            servletRequest.setCharacterEncoding(characterEncoding);
            servletResponse.setCharacterEncoding(characterEncoding);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        //销毁时清空资源
        characterEncoding = null;
    }
}
