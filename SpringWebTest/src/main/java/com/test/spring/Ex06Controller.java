package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ex06Controller {
	
	@RequestMapping(value="/ex06.action")
	public String call() {
		
		return "ex06";//jsp 이름
	}
	
	//doGet,doPost 의 역할을 수행한다. -> 구분이 가능함!
	//GET 과 POST 를 구분지어 요청받는 방법을 알아보자!
	//@RequestMapping(value="/ex06ok.action",method={RequestMethod.GET})//doGet 메서드가 된다 -> 오로지 GET 방식에만 작동함
	@RequestMapping(value="/ex06ok.action",method={RequestMethod.POST})//doPOST 메서드가 된다 -> 오로지 POST 방식에만 작동함
	public void callok() {
		
		System.out.println("호출됨");
		
	}
}
