package com.test.spring;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class BoardController {
	
	//BoardController -> BoardDAO -> Sqlsessiontemplate
	@Autowired
	private IBoardDAO dao;
	
	
	//요청 메소드(URL)
	@RequestMapping(value = "/template.action", method = { RequestMethod.GET })
	public String template(HttpServletRequest request, HttpServletResponse response) {

		
		//타일즈 레이아웃 설정 파일(WEB-INF/tiles.xml) -> <definition>의 이름
		return "template";
	}
	
	@RequestMapping(value = "/add.action", method = { RequestMethod.GET })
	public String add(HttpServletRequest request, HttpServletResponse response) {

		//글쓰기
		//1. DB 작업 -> select
		//2. 카테고리 목록 -> jsp 전달
		
		//1.
		List<CategoryDTO> clist = dao.clist();
		
		//2. 
		request.setAttribute("clist", clist);
		

		return "add";
	}
	
	@RequestMapping(value = "/addok.action", method = { RequestMethod.POST })
	public void addok(HttpServletRequest request, HttpServletResponse response,BoardDTO dto) {
		
		//1. 데이터 가져오기
		//2. 업로드 파일 처리
		//3. DB 작업 -> insert
		//4. 결과 통보
		
		//System.out.println(dto);
		//<from enctype="X"> -> request(HttpServletRequest)
		//<from enctype="multipart.."> -> request(MultipartHttpServletRequest)
		//첨부파일 처리할때만 쓸것이다.
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)request;
		
		//첨부파일 처리
		//- <input type="file" name="attach">
		MultipartFile attach = multi.getFile("attach");//첨부파일 객체 참조
		
		
		System.out.println(attach.getName());
		System.out.println(attach.getOriginalFilename());//DB 에 추가
		System.out.println(attach.getSize());
		System.out.println(attach.getContentType());
		
		//web-app > files 폴더 생성.
		//첨부된 파일을 임시 폴더에서 files 폴더로 이동하기!**
		
		try {
			
			//파일덮어쓰기 안하게 하려고 하는 작업
			String filename = attach.getOriginalFilename();//첨부파일 이름.
			
			//중복되지 않는 파일명 만들어서 반환시켜줄것이다. -> 뒤에 숫자붙일거임. 우리가 직접 해줄것이다.(***)
			filename = getFileName(request.getRealPath("files"),filename);//(경로,첨부파일 이름)
			
			
			
			File file = new File(request.getRealPath("files") + "\\" + filename);//attach.getOriginalFilename() 이 원래 filename 에 있었음
			System.out.println(file.getAbsolutePath());//아래와 같은 경로가 나오게 된다.
			//C:\Users\신승환\Desktop\java\springweb\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringBoard\files\난왜안되는거냐.txt
			//즉 위에서 말하는 위치와 우리가 새로 만든 files 폴더랑 같은 위치라고 보면 된다.
			
			attach.transferTo(file);//임시폴더 -> files 폴더로 파일을 이동한다. -> 파일업로드 완료
			
			dto.setFilename(filename);//방금 업로드한 파일명을 dto에도 추가를 해야한다.
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		//글쓰기(DAO)
		//dto.setFilename(filename);//방금 업로드한 파일명을 dto에도 추가를 해야한다. -> 오류가 나므로 위에 올려줘야 한다.
		//System.out.println(dto);
		int result = dao.add(dto);
		
		complete(result,response,"list.action");//jsp 안만들려고 만드는것이다.
		
		
	}
	
	
	

	private void complete(int result, HttpServletResponse response, String url) {
		
		try {
			response.setCharacterEncoding("UTF-8");//서버에서 클라이언트로 넘어가는 한글이라 또 자체적으로 걸어줘야 한다.
			
			PrintWriter writer = response.getWriter();
			
			writer.print("<html>");
			writer.print("<head>");
			writer.print("<meta charset='UTF-8'>");
			writer.print("</head>");
			writer.print("<body>");
			writer.print("<script>");
			
			if(result == 1) {
				writer.printf("location.href='/spring/%s';",url);
			} else {
				 writer.print("alert('실패'); history.back();");
			}
			
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			writer.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

	//면접문제!!***  
	//파일 처리 해줄것이다.	
	private String getFileName(String realPath, String filename) {
		
		//중복된 파일명 -> 뒤에 숫자 붙이기. -> test.java 가 중복이 되면  test1.java or test(1).java 이런식으로 만들어줄것이다.
		int n = 1;//그곳에 붙일 숫자를 의미한다.
		int index = filename.lastIndexOf(".");//뒤에서부터 점을 찾아서 
		
		String name = filename.substring(0,index);//"test" 를 자른것.
		String ext = filename.substring(index);//".java" 를 자른것.
		
		//중복검사
		while(true) {
			
			File file = new File(realPath + "\\" + filename);
			
			if (file.exists()) {
				//이미 같은 이름의 파일이 존재한다는 의미
				filename = name + "(" + n + ")" + ext;
				n++;
			} else {
				//같은 이름의 파일이 없음.
				return file.getName();//중복이 안된다고 결정된 이름
			}
			
		}
	}
	
	@RequestMapping(value = "/list.action", method = { RequestMethod.GET })
	public String list(HttpServletRequest request, HttpServletResponse response) {

		//목록보기
		
		//1. DB 작업 -> select
		//2. 목록 반환 -> jsp 전달하기
		
		
		List<BoardDTO> list= dao.list();
		
		request.setAttribute("list", list);
		
		return "list";//jsp 부르는게 아님.
	}
	
	@RequestMapping(value = "/view.action", method = { RequestMethod.GET })
	public String view(HttpServletRequest request, HttpServletResponse response,String seq) {

		//글 보기
		//1. 데이터 가져오기(seq)
		//2. DB 작업 -> select ... where...
		//3. BoardDTO 반환 -> JSP 호출하기
		
		BoardDTO dto = dao.get(seq);
		
		//DTO 추가 처리
		String content = dto.getContent();
		content = content.replace("\r\n", "<br>");
		dto.setContent(content);
		
		//첨부 파일 내용 읽기
		//우와 어렵다 고치긴했는데
		String temp = "";
		try {
			Scanner scan = new Scanner(new File(request.getRealPath("files") + "\\" + dto.getFilename()));
			
			while(scan.hasNextLine()) {
				temp += scan.nextLine() + "\r\n";
				System.out.println("돈다");
			}
			
			temp = temp.replace("<", "&lt;").replace(">", "&gt;");
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		request.setAttribute("dto", dto);//jsp에게 dto를 주는 작업 수행.
		request.setAttribute("code", temp);
			
		
		return "view";
	}
	
	@RequestMapping(value = "/edit.action", method = { RequestMethod.GET })
	public String edit(HttpServletRequest request, HttpServletResponse response,String seq) {

		//수정하기
		//1. 데이터 가져오기
		//2. DB 작업 -> select
		//3. DTO -> JSP 전달
		
		

		List<CategoryDTO> clist = dao.clist();
		BoardDTO dto = dao.get(seq);
		
		request.setAttribute("dto",dto);
		request.setAttribute("clist", clist);
		

		return "edit";
	}
	
	
	@RequestMapping(value = "/editok.action", method = { RequestMethod.POST })
	public void editok(HttpServletRequest request, HttpServletResponse response,BoardDTO dto) {//1.

		
		//글 수정하기.
		//1. 데이터 가져오기
		//2. 첨부파일 처리하기
		//3. DB 작업 -> update
		//4. 결과
		
		
		//2. 첨부파일 처리
		//a. 파일 교체 하는 경우
		//b. 그대로 파일 사용하는 경우
		
		//첨부파일 참조 조작.
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)request;
		//첨부파일 처리
		MultipartFile attach = multi.getFile("attach");//첨부파일 객체 참조 -> 넘어온 파일이 있는지 없는지 확인해야 한다.
		
		//System.out.println("empty : " + attach.isEmpty());//파일이 들어가있으면 false 없으면 true
		
		if (!attach.isEmpty()) {
			//첨부파일 수정함
			
			try {
				
				//예전파일은 삭제 해야 한다.
				File oldfile = new File(request.getRealPath("files") + "\\" + dto.getFilename());
				oldfile.delete();
				
				
				
				//교체할 파일이 업로드
				String filename = attach.getOriginalFilename();//첨부파일 이름.
				
				//중복되지 않는 파일명 만들어서 반환시켜줄것이다. -> 뒤에 숫자붙일거임. 우리가 직접 해줄것이다.(***)
				filename = getFileName(request.getRealPath("files"),filename);//(경로,첨부파일 이름)
				
				
				
				File file = new File(request.getRealPath("files") + "\\" + filename);//attach.getOriginalFilename() 이 원래 filename 에 있었음
				System.out.println(file.getAbsolutePath());//아래와 같은 경로가 나오게 된다.
				//C:\Users\신승환\Desktop\java\springweb\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringBoard\files\난왜안되는거냐.txt
				//즉 위에서 말하는 위치와 우리가 새로 만든 files 폴더랑 같은 위치라고 보면 된다.
				
				attach.transferTo(file);//임시폴더 -> files 폴더로 파일을 이동한다. -> 파일업로드 완료
				
				dto.setFilename(filename);//방금 업로드한 파일명을 dto에도 추가를 해야한다.
				
			} catch(Exception e) {
				System.out.println(e);
			}
			
			
		}
		
		
		
		int result = dao.edit(dto);//옛날 파일이 들어있거나 새로운 파일이 들어있거나 둘중 하나임.
		

		complete(result,response,"view.action?seq=" + dto.getSeq());
	}
	
	//바로 삭제처리 해줄것이다.
	@RequestMapping(value = "/delete.action", method = { RequestMethod.GET })
	public void delete(HttpServletRequest request, HttpServletResponse response,String seq) {//1.

		//1. 데이터 가져오기(seq)
		//1.5 첨부파일 삭제하기
		//2. DB 작업 -> delete
		//3. 결과
		
		
		BoardDTO dto = dao.get(seq);
		
		File file = new File(request.getRealPath("files") + "\\" + dto.getFilename());
		
		file.delete();//파일 삭제
		
		int result = dao.delete(seq);//2.위에서 파일 삭제한 이후 데이터 베이스로 넘어가서 데이터를 삭제해준다.
		
		complete(result,response,"list.action");
		
	}
	
}
