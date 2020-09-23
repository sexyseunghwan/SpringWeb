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
		return template.update("board.edit",dto);//매개변수 두번째가 넘어가는 것이다. board.xml로
	}

	@Override
	public int delete(String seq) {
		// TODO Auto-generated method stub
		return template.delete("board.delete",seq);
	}

	@Override
	public List<CategoryDTO> clist() {
		
		return template.selectList("board.clist");
		
	}
	
}
