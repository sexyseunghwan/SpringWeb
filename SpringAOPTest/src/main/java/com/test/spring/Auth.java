package com.test.spring;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//태생이 보조업무 객체 -> aspect 와 component 를 붙여줘야 한다.
@Aspect
@Component
public class Auth {
	
	//주업무 메소드 > pointcut 만들어야 한다.
	@Pointcut("execution(public String com.test.spring.AOPController.member*(..))")
	public void pc1() {
		
	}
	//보조 업무 + 주업무 : Weaving
	@Before("pc1()")
	public void m1(JoinPoint joinpoint) {
		//System.out.println("인증을 확인합니다.");
		
		//현재 주업무를 발생시킨 유저가 로그인 상태인지가 궁금한것이다.
		// session 을 어찌 받아오느냐? requestmappring 형식과는 다름.
		//joinpoint 가 주업무 메서드의 참조를 가져와준다(*****)
		
		
		HttpServletRequest request = (HttpServletRequest)joinpoint.getArgs()[0];
		HttpServletResponse response = (HttpServletResponse)joinpoint.getArgs()[1];
		HttpSession session = (HttpSession)joinpoint.getArgs()[2];//애가 Object 배열을 하나 반환한다.
							//HttpServletRequest request, HttpServletResponse response 애의 값을 받아온다 
							//즉 주업무 객체의 매개변수들 모두를 가져온다
							//즉 session을 가져오고 싶으면 주업무 파라미터에 세션을 넣으면된다.
		
		if (session.getAttribute("id") == null) {
			System.out.println("=========");
			System.out.println("로그인 안함");
			//여기서 쫓아내야 한다! -> 로그인을 안했으므로 !
			//1. response.sendRedirect() -> 말없이 보내기
			//2. alert() + location.href -> 말하고 보내주기
			
			try {
				
				response.setCharacterEncoding("UTF-8");
				
				PrintWriter writer = response.getWriter();
				
				writer.print("<html>");
				writer.print("<head>");
				writer.print("<meta charset='UTF-8'>");
				writer.print("<body>");
				writer.print("<script>");
				writer.print("alert('로그인 하세요');");
				writer.print("location.href='/spring/index.action';");
				writer.print("</script>");
				writer.print("</body>");
				writer.print("</html>");
				
				writer.close();
				
			} catch(Exception e) {
				System.out.println(e);
			}
			
			
		} else {
			System.out.println("=========");
			System.out.println("로그인 함");
		}
		
		
		
	}
	
	
}
