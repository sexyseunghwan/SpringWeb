package com.test.spring;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	@Pointcut("execution(public String AOPController.member*(..))")
	public void pc1() {
		
	}
	
	@After("pc1()")
	public void m1(JoinPoint joinpoint) {
		
		//로그를 남긴다.
		//1. 시간
		//2. 누가 -> session을 뒤져봐야 알 수 있다.
		//3. 어떤 페이지 방문 했는지 -> request
		
		HttpServletRequest request = (HttpServletRequest)joinpoint.getArgs()[0];
		HttpSession session = (HttpSession)joinpoint.getArgs()[2];
		
		
		//기록
		System.out.printf("[log] %tF %tT\n",Calendar.getInstance(),Calendar.getInstance());
		System.out.println("[log]" + session.getAttribute("id"));
		System.out.println("[log]" + request.getRequestURL());
		
		
	}
	
}
