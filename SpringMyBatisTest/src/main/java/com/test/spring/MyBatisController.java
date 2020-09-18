package com.test.spring;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//객체간의 관계
//Controller(전체적인 관리하는 최상위 계층) <-> ISevice(Service) <-> DAO <-> MyBatis <-> Oracle
//                                  DTO                  DTO     DTO         
@Controller
public class MyBatisController {
	
	//스프링이 자동으로 의존주입 -> 자동으로 객체만들어서 넣어준다.
	@Autowired
	private IMyBatisService service;
	
	@RequestMapping(value = "/m1.action", method = { RequestMethod.GET })
	public String m1(HttpServletRequest request, HttpServletResponse response) {

		//반환값 x 인자값 x -> 정적 쿼리
		service.m1();
		
		return "result";
	}
	
	
	@RequestMapping(value = "/m2.action", method = { RequestMethod.GET })
	public String m2(HttpServletRequest request, HttpServletResponse response) {

		//반환값 x 인자값o(단일값) 쿼리 날릴것.
		String seq = "1";//숫자를 받았다고 치자.m2.action?seq=1
		//홍길동의 나이를 한살 업데이트 시키는 작업을 하자.
		
		int result = service.m2(seq);
		
		request.setAttribute("result", result);
		
		return "result";
	}
	
	@RequestMapping(value = "/m3.action", method = { RequestMethod.GET })
	public String m3(HttpServletRequest request, HttpServletResponse response,String name,String age,String etc) {

		//반환값x, 인자값o(여러개의 인자값을 넘길것.) -> 행에대한 여러가지 데이터를 넘길것!! (name,age,etc)
		
		//인자값 -> 다중값 -> HashMap or DTO
		//m3.action?name=홍길동&age=20&etc=테스트용 -> 위에 매개변수에 넣어주면 된다.
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name",name);
		map.put("age",age);
		map.put("etc",etc);
		
		int result = service.m3(map);
		
		request.setAttribute("result", result);
		
		
		return "result";
	}
	
	@RequestMapping(value = "/m4.action", method = { RequestMethod.GET })
	public String m4(HttpServletRequest request, HttpServletResponse response, MyBatisDTO dto) {

		//반환값x, 인자값o(여러개의 인자값을 넘길것.) -> 
		//m3.action?name=홍길동&age=20&etc=테스트용 -> 위에 매개변수에 넣어주면 된다.
		//똑같이 get방식으로 넘길것이다.
		//이번에는 DTO를 쓸것이다.
		
		int result = service.m4(dto);
		
		request.setAttribute("result",result);
		
		return "result";
	}
	
	
}
