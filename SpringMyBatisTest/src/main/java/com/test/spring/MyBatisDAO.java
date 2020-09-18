package com.test.spring;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//DAO 한테는 리파짓토리 어노테이션을 붙이는게 관례
@Repository
public class MyBatisDAO {
	
	//dao 에서 반드시 필요한 객체 connect, statement,resultset 이 있어야함!
	//MyBatis 를 쓸때는 SqlSessionTemplatedlrp 이게 필요함
	@Autowired
	private SqlSessionTemplate template;//myBatis -> Statement + resultSet역할 근데 또 애한테 의존하므로 의존주입 해야함
	// SqlSessionTemplate 여기가서 또 어노테이션 달아야 되는데 그럴필요 없음 우리가 만든 클래스가 아니므로

	public void m1() {
		
		//진짜 db 작업 수행해주면 된다.
		
//		stat.executeUpdate
//		- template.insert();
//		- template.update();
//		- template.delete();
		
//		stat.executeQuery
//		- template.select();
		
		//test.m1
		// -> 매퍼에 있는 쿼리들 중 네임스페이스가 test 이고 id 가 m1인 쿼리를 찾아서 호출해라.
		// 
		template.insert("test.m1");
		
		
		
		
	}

	public int m2(String seq) {
		
		//매개변수가 존재함.
		
		return template.update("test.m2",seq);//매개변수용 오브젝트가 존재하므로 넣어서 가면 된다. 성공하면 1 실패하면 0을 반환해준다. 저 파일 이름을 매퍼라고 부른다.
	}

	
	public int m3(HashMap<String, String> map) {
			
		return template.insert("test.m3",map);
	}

	public int m4(MyBatisDTO dto) {
		
		
		return template.insert("test.m4",dto);
	}

	
	
}
