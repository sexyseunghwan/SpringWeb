package com.test.spring;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex05Controller {
	
	//글쓰기 구현(add + addok)
	@RequestMapping(value="/board/add.action")//가상주소 매핑. -> id 역할을 수행한다. 즉 복붙과정에서의 주의가 필요하다!.
	public String add() {
		
		return "ex05";
		
	}
	
	//Spring mvc 에서 전송된 데이터를 수신하는 방법에대해 이야기 해보자.
	//해당ok메서드는 jsp 페이지를 만들지 않을것이다.	
	@RequestMapping(value="/board/addok.action")
	public void addok(
						HttpServletRequest request,
						HttpServletResponse response,
						BoardDTO dto, //subject,content,name 가져오기
						String seq//이런식으로 받으면 된다. dto 로 포장해서 보내기 힘들면 그냥 각자 보내도 상관이 없다!.
						//String subject,//request.getParameter("subject"); 의 역할을 수행한다.
						//String content,//request.getParameter("content"); 의 역할을 수행한다.
						//String name//request.getParameter("name"); 의 역할을 수행한다.
						
			) {//매개변수의 순서는 여기서는 중요하지 않음 
		
		// (????)대체 여기서 seq 는 뭐하는 놈이지?..		
		
		//현재상황 -> 상상해라
		//1. 데이터 가져오기
		//2. DTO 포장
		//3. DAO 호출  DTO 전달 -> insert 
		//4. 마무리
		
		//방법1. 기존에 사용하던 방식. -> request 를 사용하는 방식 -> 매개변수에 넣어준다 HttpServletRequest request을
//		String subject = request.getParameter("subject");
//		String content = request.getParameter("content");
//		String name = request.getParameter("name");
//		
//		BoardDTO dto = new BoardDTO();
//		dto.setName(name);
//		dto.setContent(content);
//		dto.setSubject(subject);
		
		
		
		
		//방법2. 요청 메소드의 매개변수를 사용.(request 사용 안함.)
//		BoardDTO dto = new BoardDTO();
//		dto.setName(name);
//		dto.setContent(content);
//		dto.setSubject(subject);
		
		
		//방법3. 요청 메소드의 매개변수를 사용.(request 사용 안함.)(******)
		//매개변수에 그냥 BoardDTO dto 를 넣어버림...
		
		
		//확인
		System.out.println(dto);
		System.out.println(seq);
		
		
		//BoardDAO 가 있다고 치고 
		//dao.add(dto) 한다고 생각해보자.
		try {
			PrintWriter writer = response.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>alert('complete');</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			writer.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
