package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AOPController {
	
	
	//AOPController -> Service -> DAO -> SqlSessionTemplate(MyBatis)
	
	@Autowired
	private IService service;//직접 안만들고 auto써서 의존주입형식으로 만들어야 한다.
	
	//주업무
	@RequestMapping(value = "/index.action", method = { RequestMethod.GET })
	public String index(HttpServletRequest request, HttpServletResponse response) {

		//시작 페이지
		int count = service.getCount();
		
		request.setAttribute("count", count);

		return "result";//result.jsp 를 부르게 된다.
	}
	
	//로그인
	@RequestMapping(value = "/login.action", method = { RequestMethod.GET })
	public String login(HttpServletRequest request, HttpServletResponse response,HttpSession session) {

		//인증티켓 발급
		session.setAttribute("id", "hong");
		
		return "result";
	}
	
	
	//로그아웃
	@RequestMapping(value = "/logout.action", method = { RequestMethod.GET })
	public String logout(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		
		
		//인증 티켓 소멸
		session.removeAttribute("id");
		
		return "result";
	}
	
	//회원 페이지
	@RequestMapping(value = "/member.action", method = { RequestMethod.GET })
	public String member(HttpServletRequest request, HttpServletResponse response,HttpSession session) {

		//보조 업무 추가 > 로그인 안함 사람들을 쫓아내기 -> AOP 방식으로 진행해줄것이다. 직접구현하지 않을거라는 이야기임.
		
		return "member";
	}

	//애도 회원전용 페이지라고 해보자.
	//애도 손쉬운 방법으로 보조 업무를 붙일 수 있다!!
	@RequestMapping(value = "/memberinfo.action", method = { RequestMethod.GET })
	public String memberinfo(HttpServletRequest request, HttpServletResponse response,HttpSession session) {

		//보조 업무 추가 > 로그인 안함 사람들을 쫓아내기 -> AOP 방식으로 진행해줄것이다. 직접구현하지 않을거라는 이야기임.
		
		return "member";
	}
	
	
	
}
