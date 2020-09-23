package com.test.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//애가 보조업무 객체 역할을 수행할것이다.
//Aspect 를 쓰면 보조업무 객체의 자격을 얻게 된다. -> spring 이 알아서 만들것이다.
// Component : 의존주입 자격을 얻게 되는거 Repository Service 와 같은놈임. 
@Aspect
@Component
public class Cross {
	
	//주 업무 메소드를 지정 > Point cut 생성
	@Pointcut("execution(public int com.test.spring.Service.getCount())")
	public void pc1() {
		//안에 뭐 적으나 마나 그냥 바지사장 느낌으로 가는거
	}
	
	//보조 업무
	//아래와 같이 사용하면 된다 시그너쳐를 적으면 된다 주업무의 시그너처
	@Before("pc1()")
	public void m1() {
		System.out.println("보조업무가 실행되었습니다.");
	}
	
	//보조업무와 주업무를 엮어야 한다!
	
	
	
	
}
