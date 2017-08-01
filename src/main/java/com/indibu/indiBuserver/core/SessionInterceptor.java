package com.indibu.indiBuserver.core;


import com.indibu.indiBuserver.model.IndibuException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class SessionInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {

        HttpSession session = httpServletRequest.getSession();
        if (session.isNew() || session.getAttribute(Constants.USER_ID_SESSION_ATTRIBUTE) == null) {
            throw new IndibuException("Session süreniz dolmuştur, yeniden giriş yapınız.", HttpStatus.FORBIDDEN);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
