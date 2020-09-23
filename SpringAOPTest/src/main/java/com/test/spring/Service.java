package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service implements IService{
	
	//서비스는 DAO 를 의존한다.
	@Autowired
	private DAO dao;
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dao.getCount();
	}
	
	
}
