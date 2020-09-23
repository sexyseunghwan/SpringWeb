package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class Service implements IService{
	
	@Autowired
	private DAO dao;
	
	//스프링 트랜잭션은 메소드 단위로 지원한다.
	@Override
	@Transactional//트랜잭션 처리
	public int add(DTO dto) {
		//해당 메서드 전체를 트랜잭션으로 묶는다.
		
		int result = 0;
		
		result += dao.point(dto);//포인트 증가.
		
		result += dao.add(dto);//글쓰기
		
		
		return result;
	}
	
}
