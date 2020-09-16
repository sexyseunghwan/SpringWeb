package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemoController {
	
	//템플릿 작업
	@RequestMapping(value="/template.action",method= {RequestMethod.GET})
	public String template(HttpServletRequest request, HttpServletResponse response) {
	
//		MemoDTO dto = new MemoDTO();//롬복 적용한 객체 생성. -> 알아서  setter 만들어준다!. getter 도 알아서 만들어준다!
//		dto.setName("홍길동");
//		System.out.println(dto.toString());
//		
		
		MemoDAO dao = new MemoDAO();
		
		return "template";
	}
}
