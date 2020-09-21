package com.test.spring;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex04Controller {
	
	
	//그냥 객체들을 다 한번에 생성하고 연결하는 역할을 수행하는거 같은데?! -> 맞는거 같은데?! 마쟈 맞는거 같음...
	
	@RequestMapping(value="/board/add.action")//action 을 붙여줘야  dispatcher servlet 이 찾아주는거지 너를...
	public String add() {
		
		return "ex04";
		
	}
	
		
	
	//이거 연습해봐야 된다.,..
	
	@RequestMapping(value="/board/addok.action")
	public void addok(HttpServletRequest req, HttpServletResponse resp, BoardDTO dto,String seq) {
		
		System.out.println(dto);
		System.out.println(seq);
		
		try {
			
			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>alert('complete')</script>");
			writer.print("</body>");
			writer.print("</html>");
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}
