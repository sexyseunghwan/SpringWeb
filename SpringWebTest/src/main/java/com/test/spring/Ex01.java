package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//- 기존의 서블릿 역할을 하는 클래스
//- 서블릿(X)
//- Servlet/JSp MVC 구조 : 서블릿(컨트롤러 역할)

//컨트롤러 선언
//1. Controller 인터페이스 구현
//2. @Controller 어노테이션 적용

// Controller 인터페이스 구현 -> DispatcherServlet 에 의해서 호출당할수 있는 자격을 가지게 된다. 
public class Ex01 implements Controller{

	
	
	//handlerequest
	// - doGet/doPost 메소드 역할
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//비즈니스 코드 구현(업무구현)...
		int count = 10;//DB
		String name = "hong";
		
		request.setAttribute("count", count);
		
		//JSP 호출하기...등등
		
		//RequestDispatcher 사용 안함 -> ModelAndView 사용
		ModelAndView mv = new ModelAndView();
		
		
		mv.addObject("name",name);//request.setAttribute("count", count); 이 방식과 같은놈이라고 생각하면 된다. 100% 같은코드라고 생각하면 된다.
		
		
		//mv.setViewName("/WEB-INF/views/ex01.jsp");//jsp 를 찾는데 사용함. -> jsp의 위치를 지정한다.
		mv.setViewName("ex01");//이제 이방식으로 써주면 된다 위의 경로를
		
		//http://localhost:8090/spring/ex01.action 이런식으로 브라우저 직접 쳐서 들어가야된다!.-> spring 특성
		return mv;//애가 곧 forwarding 이 된다.
	}

}
