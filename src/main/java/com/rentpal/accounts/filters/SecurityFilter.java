package com.rentpal.accounts.filters;

/*
 * @author frank
 * @created 14 Dec,2020 - 8:31 PM
 */

import com.rentpal.accounts.common.RentpalThreadLocal;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RentpalThreadLocal.init();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if(request.getHeader("email")!=null){
            RentpalThreadLocal.add("email", request.getHeader("email"));
        }
        if(request.getHeader("id")!=null){
            RentpalThreadLocal.add("id", request.getHeader("id"));
        }
        filterChain.doFilter(servletRequest, servletResponse);
        RentpalThreadLocal.clear();
    }

}
