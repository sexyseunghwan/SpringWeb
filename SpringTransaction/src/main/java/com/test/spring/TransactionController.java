package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TransactionController {
	
	@Autowired
	private IService service;
	
	@RequestMapping(value = "/add.action", method = { RequestMethod.GET })
	public String add(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "add";
	}
	
	@RequestMapping(value = "/addok.action", method = { RequestMethod.POST })
	public String addok(HttpServletRequest request, HttpServletResponse response,DTO dto) {//1.

		//글쓰기
		//1. 데이터 가져오기
		//2. DB 작업 -> insert + update
		//3. 결과 반환 + JSP 호출
		
		//DB 작업 -> 2가지  -> 글쓰기 + 포인트 증가.
		// 
				
		int result = service.add(dto);
		
		request.setAttribute("result", result);
		
		

		return "addok";
	}
	
}




