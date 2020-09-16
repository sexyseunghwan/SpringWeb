package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 구현
//1. Controller 인터페이스 구현
//2. @Controller 어노테이션 사용 -> 상대적으로 편한 방법.

//서블릿 역할 + 컨트롤러
@Controller
@RequestMapping(value="/ex04.action")//이런식으로 해주면 servlet-context에 갈 필요가 없어진다. <beans:bean class="com.test.spring.Ex01" name="/ex01.action"></beans:bean> 애들 그냥 만들어준다고 생각하면 된다.
public class Ex04Controller {
	
	//요청 메서드 > handleRequest 를 만들어야 되는데 이때까지는 인터페이스를 상속받아서 만들었는데 지금은 인터페이스 구현을 안했는데 : 즉 필수적으로 만들어야 되는게 없어진다.
	//-> 맘대로 만들면 된다.
	
	//아래와 같이 어노테이션을 달면 해당 메서드가 doGet(),doPost()와 같은놈으로 생각해준다!
	//어노테이션을 써서 컨트롤러로 만드면 나머지 코드도 모두 바뀌게 된다!
	@RequestMapping
	public String test() {
		
		//업무구현...
		
		
		//JSP 호출하기
		//주로 문자열로 리턴을 해서 views 페이지로 이동하게 해준다.
		return "ex04";//WEB-INF/views/ex04.jsp 를 뜻하는것임. -> 이게 jsp 를 찾아감 그냥 리턴 저렇게 써도 ㅋㅋㅋ
		//ViewResolver 를 안쓰게 되면  /WEB-INF/views/ex04.jsp 이렇게 직접 써줘야 한다!
	}	
}
