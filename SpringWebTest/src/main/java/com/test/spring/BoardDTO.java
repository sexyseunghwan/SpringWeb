package com.test.spring;

public class BoardDTO {
	
	//중요!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//<input type="text" name = "subject"> -> DTO private String subject 이름을 같게 해줘야 함!!! 꼭 매우중요 (************************)
	private String subject;
	private String content;
	private String name;

	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return " [subject=" + subject + ", content=" + content + ", name=" + name + "]";
	}
	
	
	
}
