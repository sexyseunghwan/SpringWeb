package com.test.spring;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Autowired 에 대해서 의존 주입 객체가 되려면 선언해야 하는 어노테이션이 존재
//@Repository여기서는 이거 안붇여 -> dao 일때만 이 이름을 짓는것이다
//Repository 랑 똑같은 역할인데 단어구분자임 그냥 어떤 작업일때 적냐  구분하는것임.
@Service
public class MyBatisService implements IMyBatisService{
	
	//MyBatisService 도  DAO 를 의존해야한다 -> 의존주입이 필요함. 
	@Autowired
	private MyBatisDAO dao;
	
	
	@Override
	public void m1() {
		//dao 한테 일을 맡긴다.
		dao.m1();
		
		
	}


	@Override
	public int m2(String seq) {
		//dao 한테 일을 맡긴다.
		
		return dao.m2(seq);
	}


	@Override
	public int m3(HashMap<String, String> map) {
		
		return dao.m3(map);
	}


	@Override
	public int m4(MyBatisDTO dto) {
		
		return dao.m4(dto);
	}
	
	
}
