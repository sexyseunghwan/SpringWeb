package com.test.spring;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemoController {
	
	//서블릿때는 다 다른 페이지에 있어서 힘들었지만 이거는 한 페이지에 있으므로 dao를 멤버로 만들어준다(전역변수 역할)
	@Autowired//아래 변수에 객체를 자동으로 생생해서 넣어라 라는 뜻이된다ㅣ(***) 의존 주입 즉 애는 의존주입 어노테이션이라고 보면된다. -> 생성자나 setter를 만들지 않아도 된다.
	private IMemo dao;//의존객체!! -> "의존주입"을 시켜야 한다! -> 최종방법으로 어노테이션 사용...의존주입을 시켜야되는데?!
	//원래대로라면  private IMemo dao = new MemoDAO() 이런식으로 객체를 만들어야 되는데
	//실제로 MemoDAO 클래스로 가서 클래스 이름 위에 @Repository 를 붙여주면 된다(***)
	
	
	//템플릿 작업
	@RequestMapping(value="/template.action",method= {RequestMethod.GET})
	public String template(HttpServletRequest request, HttpServletResponse response) {
	
		return "template";
	}//주소하나당 하나씩 만들어지게 될것이다!.
	
	//메모쓰기
	@RequestMapping(value = "/add.action", method = { RequestMethod.GET })
	public String add(HttpServletRequest request, HttpServletResponse response) {
		
		//쓰기이므로 여기서 따로 할 업무는 없음.
		return "add";
	}
	
	//메모쓰기 ok 작업 -> jsp 로 안만드니까 반환값이 없는 void 를 사용한다.
	@RequestMapping(value = "/addok.action", method = { RequestMethod.POST })
	public void addok(HttpServletRequest request, HttpServletResponse response, MemoDTO dto) {
		
		//전형적인 insert 작업을 수행하면 된다.
		//1. 데이터 가져오기
		//2. DB 작업 -> insert
		//3. 마무리 하기. 
		
		
		//1. 데이터 가져오기! -> 이름과 메모를 가져와야 한다. -> 매개변수를 사용 -> 판단기준 : 지금넘긴 데이터가 dto안에 변수로 존재하는지 체크 -> 그럼 dto로 한번에 받으면 되고 아니면 따로따로 받으면 된다
		//매개변수 하나 추가 !! -> MemoDTO dto 매개변수를 추가해준다.
		
		//System.out.println(dto);//확인해준다.
		
		//2.DB 작업 -> insert
		int result = dao.add(dto);//1또는 0이 될것이다.
		
		//3. 마무리 작업
		response.setCharacterEncoding("UTF-8");
		try {
			
			PrintWriter writer = response.getWriter();
			
			
			writer.print("<html>");
			writer.print("<head>");
			writer.print("<meta charset='utf-8'>");
			writer.print("</head>");
			writer.print("<body>");
			
			writer.print("<script>");
			if (result == 1) {
				writer.print("alert('성공'); location.href='/spring/index.action';");
			} else {
				writer.print("alert('실패'); history.back();");
			}
			
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//메모보기 (목록 보기)
	@RequestMapping(value = "/index.action", method = { RequestMethod.GET })
	public String index(HttpServletRequest request, HttpServletResponse response) {

		//List
		//1. 데이터 가져오기
		//2. JSP 호출하기 + 결과 전달하기.
		
		//dao 만들어야 되는데 만들필요 없다고! 위에 전역으로 만들어 놨다구
		
		//1.
		List<MemoDTO> list = dao.list();
		
		//2.
		request.setAttribute("list", list);//담아서 넘기면 된다.

		return "index";
	}
	
	
	//메모 수정
	@RequestMapping(value = "/edit.action", method = { RequestMethod.GET })
	public String edit(HttpServletRequest request, HttpServletResponse response,String seq) {

		//1. 데이터 가져오기
		//2. DB 작업 -> select
		//3. JSP 호출하기 + DTO 전달하기
		
		//1.
		//매개변수에서 그냥 넘어오는거 가져오면 된다. -> 매개변수를 하나 만들어서 넣어준다 : String seq -> 자동으로 리퀘스트 가능.
		
		//2.
		MemoDTO dto = dao.get(seq);
		
		request.setAttribute("dto", dto);
		

		return "edit";
	}
	//메모수정
	@RequestMapping(value = "/editok.action", method = { RequestMethod.POST })
	public void editok(HttpServletRequest request, HttpServletResponse response,MemoDTO dto) {
		
		//1. 데이터 가져오기(데이터가 3개가 넘어올 것이다.)
		//2. DB 작업 -> update
		//3. 결과 출력
		
		//1. 
		
		//2.
		int result = dao.edit(dto);
		
		//3. 마무리 작업
		response.setCharacterEncoding("UTF-8");
		try {
			
			PrintWriter writer = response.getWriter();
			
			
			writer.print("<html>");
			writer.print("<head>");
			writer.print("<meta charset='utf-8'>");
			writer.print("</head>");
			writer.print("<body>");
			
			writer.print("<script>");
			if (result == 1) {
				writer.print("alert('성공'); location.href='/spring/index.action';");
			} else {
				writer.print("alert('실패'); history.back();");
			}
			
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//메모 삭제하기
	@RequestMapping(value = "/del.action", method = { RequestMethod.GET })
	public String del(HttpServletRequest request, HttpServletResponse response, String seq) {

		//1. 데이터 가져오기 ->seq 를 넘겨야 지우지
		//2. JSP 호출하기 + 데이터 전달하기
		
		request.setAttribute("seq", seq);
		
		return "del";
	}
	@RequestMapping(value = "/delok.action", method = { RequestMethod.GET })
	public void delok(HttpServletRequest request, HttpServletResponse response,String seq) {

		//1. 데이터 가져오기
		//2. DB 작업 -> delete
		//3. 결과 출력
		
		
		//1.
		//매개변수 String seq 추가
		
		//2. dao 위임
		int result = dao.del(seq);
		
		//3. 성공여부 출력
		response.setCharacterEncoding("UTF-8");
		try {
			
			PrintWriter writer = response.getWriter();
			
			
			writer.print("<html>");
			writer.print("<head>");
			writer.print("<meta charset='utf-8'>");
			writer.print("</head>");
			writer.print("<body>");
			
			writer.print("<script>");
			if (result == 1) {
				writer.print("alert('성공'); location.href='/spring/index.action';");
			} else {
				writer.print("alert('실패'); history.back();");
			}
			
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		
	}
}

