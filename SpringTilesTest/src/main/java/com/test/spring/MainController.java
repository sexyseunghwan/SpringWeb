package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	//회원 > 정보
	@RequestMapping(value = "/member/info.action", method = { RequestMethod.GET })
	public String info(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		//기존 ViewResolver : JSP 페이지를 찾는다
		//return "member/info"; //"/WEB-INF/views/" + "member/info" + ".jsp"

		//새로운 Tiles ViewResolver : tiles.xml 에 가서-> <definition> 의 name 을 찾는다.(****)
		return "member.info";
	
	}
	
	//회원 > 포인트
	@RequestMapping(value = "/member/point.action", method = { RequestMethod.GET })
	public String point(HttpServletRequest request, HttpServletResponse response) {
		
		

		return "member.point";
	
	}
	
	//회원 > 게시판
	@RequestMapping(value = "/member/board.action", method = { RequestMethod.GET })
	public String board(HttpServletRequest request, HttpServletResponse response) {
		
		

		return "member.board";
	
	}
	
	//관리자 > 로그
	@RequestMapping(value = "/admin/log.action", method = { RequestMethod.GET })
	public String log(HttpServletRequest request, HttpServletResponse response) {
			
			

		return "admin.log";
//		여기서 넘어가면 멤버가 앞에 붙게되므로...
		
	}
	
	//관리자 > 멤버
	@RequestMapping(value = "/admin/member.action", method = { RequestMethod.GET })
	public String member(HttpServletRequest request, HttpServletResponse response) {
			
			

		return "admin.member";
		
	}
	
	//관리자 > 차트
	@RequestMapping(value = "/admin/chart.action", method = { RequestMethod.GET })
	public String chart(HttpServletRequest request, HttpServletResponse response) {
			
			

		return "admin.chart";
		
	}
	
	
}


