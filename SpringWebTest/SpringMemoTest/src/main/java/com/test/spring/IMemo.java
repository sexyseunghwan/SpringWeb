package com.test.spring;

import java.util.List;

public interface IMemo {

	//글쓰기
	int add(MemoDTO dto);
	
	//목록보기
	List<MemoDTO> list();//목록 반환을 List 로 했으므로
	
	//수정하기
	MemoDTO get(String seq);//수정하기 전에 한번 봐줘야 되므로
	int edit(MemoDTO dto);
	
	//삭제하기
	int del(String seq);
	
	
}
