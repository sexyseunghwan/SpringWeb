package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/ex03.action")
public class Ex03Controller {
	
	@RequestMapping
	public String test() {
		
		return "ex03";
	}
	
}