package com.test.spring;

import lombok.Data;

@Data
public class BoardDTO {
	
	private String seq;
	private String subject;
	private String content;
	private String filename;
	private String regdate;
	private String cseq;
	private String cname; //카테고리명
	
	@Override
	public String toString() {
		return "BoardDTO [seq=" + seq + ", subject=" + subject + ", content=" + content + ", filename=" + filename
				+ ", regdate=" + regdate + ", cseq=" + cseq + ", cname=" + cname + "]";
	}
	
	
	
}
