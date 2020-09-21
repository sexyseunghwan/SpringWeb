package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Ex01 implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//비즈니스 코드 구현(업무구현)
		int count = 10;
		String name = "hong";
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("count",count);
		mv.addObject("name",name);
		
		
		
		return mv;
	}

}
