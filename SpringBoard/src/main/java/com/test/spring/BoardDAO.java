package com.test.spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BoardDAO implements IBoardDAO{
	
	@Autowired
	private SqlSessionTemplate template;//애가 쿼리날림
	
	@Override
	public int add(BoardDTO dto) {
		//글쓰기
		return template.insert("board.add",dto);
	}
	
	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return template.selectList("board.list");
	}

	@Override
	public BoardDTO get(String seq) {
		// TODO Auto-generated method stub
		return template.selectOne("board.get",seq);
	}

	@Override
	public int edit(BoardDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CategoryDTO> clist() {
		
		return template.selectList("board.clist");
		
	}
	
}
