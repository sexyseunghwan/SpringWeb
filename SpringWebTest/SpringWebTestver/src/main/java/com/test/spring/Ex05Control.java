package com.test.spring;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex05Control {
	
	
	@RequestMapping(value="/korea/edit.action")
	public String edit() {
		
		return "ex05";
		
	}
	
	
	@RequestMapping(value="/korea/editok.action")
	public void editok(HttpServletRequest req, HttpServletResponse resp, EditDTO dto) {
		
		System.out.println(dto);
		
		
		
		
		try {
			
			PrintWriter writer = resp.getWriter();
			
			writer.write("<html>");
			writer.write("<body>");
			writer.write("<div>" + dto.getSeq() + "</div>");
			writer.write("<div>" + dto.getName() + "</div>");
			writer.write("<div>" + dto.getPlace() + "</div>");
			writer.write("</body>");
			writer.write("</html>");
			
			writer.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	
}
