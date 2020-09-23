package com.test.spring;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	
	@Autowired
	private SqlSessionTemplate template;
	
	//DAO 에서 메서드 1개는 1개의 SQL 만 실행시키면 된다!
	//1개의 메소드 안에서 2개 이상의 SQL 을 실행하는 것은 권장하지 않는다.
	
	
	public int add(DTO dto) {
		return template.insert("tran.add",dto);//글쓰기
	}
	
	public int point(DTO dto) {
		return template.update("tran.point",dto);//포인트 증가
	}
	
}
