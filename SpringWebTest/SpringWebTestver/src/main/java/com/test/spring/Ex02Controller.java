package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Ex02Controller implements Controller{
	
	private TestDAO dao;
	private Etc etc;
	
	//생성자 역할을 수행할때 잘 봐줘야 한다
//	public Ex02Controller() {
//		this.dao = null;
//	}
//	
//	public Ex02Controller(TestDAO dao) {
//		this.dao = dao;
//	}
	
	public Ex02Controller() {
		this.etc = null;
	}
	
	public Ex02Controller(Etc etc) {
		this.etc = etc;
		System.out.println("까꿍");
	}
	
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String result = etc.write();
		
//		그니까 애가 일을 하기 위해서는 TestDAO 가 필수적인데 ...
		
//		TestDAO dao = new TestDAO(); 
		
//		int count = dao.getCount();
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("result",result);
		
		mv.setViewName("ex02");
		
		return mv;
	}
	
}
