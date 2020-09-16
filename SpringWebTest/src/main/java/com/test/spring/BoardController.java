package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value="/list.action")
public class BoardController {
	
	//글 목록 보기
	@RequestMapping(value="/list.action")
	public String list() {
		
		
		return "list";
		
	}
	
	//글쓰기
	@RequestMapping(value="/add.action")
	public String add() {
		
		return "add";
	}
	
	
	@RequestMapping(value="/addok.action")
	public void addok() {
		
		//뷰가 없는애는 이런식으로 만든다.
		
	}
	
	//글보기
	@RequestMapping(value="/view.action")
	public String view() {
			
		return "view";
	}
	
	//즉 servlet으로 치면 하나의 서블릿 안에 여러개의 jsp 를 넣어버린거
	//즉 불필요하던 서블릿을 계속해서 생성하지 않아도 된다.
	
}
