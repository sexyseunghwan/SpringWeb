package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//1. 컨트롤러 자격을 부여한다 -> 인터페이스 상속
//	- new Ex03Controller(dao) 이 객체가 없음 -> 스프링이 만들어준다. 그럼 생성자를 어케 쓰냐???! -> servlet-context 로 간다.
// 즉 new Ex03Controller(dao) 이 만들어지는 시점은 getBean 하는 시점이라고 보면 된다.
public class Ex03Controller implements Controller{
	
	private TestDAO dao;//B.
	
	public Ex03Controller() {//C.
		this.dao = null;
	}//오버로딩 안된 기본 생성자를 만들어 주는게 좋다
	
	public Ex03Controller(TestDAO dao) {//C.
		this.dao = dao;
	}
	
	public void setDAO(TestDAO dao) {//C.
		this.dao = dao;
	}
	
	//2. 요청 메서드(doGet, doPost와 같은 역할을 수행)
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//3. 업무구현.(DB)
		//int count = 1000;//데이터 베이스 다녀와서 데이터를 가져왔다고 치자
		//이제 진짜 DAO 를 만들어보자
		
		//TestDAO dao = new TestDAO();//의존 객체 -> 의존주입형태로 바꿀것임 A.
		
		int count = dao.getCount();//업무 위임.-> 아직 껍데기임 null임
		
		//4. JSP 호출하기
		ModelAndView mv = new ModelAndView();//뷰를 호출하는 작업 + 데이터를 전달하는 작업
		
		mv.addObject("count",count);//request.setAttribute("count",count) 와 같은 코드임.
		
		//mv.setViewName("/WEB-INF/views/ex03.jsp");//원래 기존대로라고 하면 이런식으로 적어야 하는건데 -> 장치가 하나더 추가 되서 편하게 적을 수 있는것이다.
		mv.setViewName("ex03");//그냥 이런식으로만 써도 위처럼 적용을 해준다 : 경로를 단축해서 표기한것이다.
		
		return mv;
	}

}
