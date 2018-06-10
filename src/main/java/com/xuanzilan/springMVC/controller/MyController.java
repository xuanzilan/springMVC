package com.xuanzilan.springMVC.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        //其底层实现的是request.setAttribute()方法
        mv.addObject("message","Hello, SpringMVC");
        mv.setViewName("webapp/WEB-INF/jsp/welcome.jsp");
        return null;
    }
}
