package com.test.spring;

import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	
	//DAO 가 진짜 작업을 해야 되는것
	public int getCount() {
		// TODO Auto-generated method stub
		return 100;//원래는  DB 작업을 수행해야 되는거임 지금은 그냥 했다고 치고 가져오는 것이다.
	}
	
	//@Auto~해야된다
	//private SqlSessionTemplate template; 원래는 이런식으로 해애되는데 이번에는 DB 에는 다녀오지 않을것이다.
	
	
}
