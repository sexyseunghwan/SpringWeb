package com.test.spring;

import java.util.List;

public interface IBoardDAO {
	
	//글쓰기
	int add(BoardDTO dto);
	
	//목록보기
	List<BoardDTO> list();
	
	//글 보기
	BoardDTO get(String seq);
	
	//수정하기(전)
	//BoardDTO get(String seq);
	
	//수정하기(후)
	int edit(BoardDTO dto);
	
	//삭제하기
	int delete(String seq);
	
	
	//카테고리 목록 가져오기.
	List<CategoryDTO> clist();
	
}
