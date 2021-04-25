package com.zhu.bms.filter;

import javax.servlet.*;
import java.io.IOException;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/19
 *   Time: 17:27
 */

public class CharacterFilter implements Filter {

    String encoding = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取初始化参数
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(encoding != null){
            //设置request字符编码
            request.setCharacterEncoding(encoding);
            //设置response字符编码
            response.setContentType("text/html;charset="+encoding);
        }
        //传递给下一个过滤器
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        encoding = null;
    }
}

