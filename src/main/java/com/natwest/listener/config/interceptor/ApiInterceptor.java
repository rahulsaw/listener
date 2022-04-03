package com.natwest.listener.config.interceptor;

import com.natwest.listener.exception.ListenerApiException;
import com.natwest.listener.exception.ListenerBaseException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
created by Rahul sawaria on 03/04/22
*/
@Component
public class ApiInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest requestServlet, HttpServletResponse responseServlet, Object handler) {

        if (requestServlet.getHeader("client").equals("publisher"))
            return true;

        throw new ListenerBaseException(ListenerApiException.UNAUTHORIZED.getMessage());
    }
}
