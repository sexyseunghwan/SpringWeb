package com.test.spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MemoDAO {
	
	//JDBC -> Spring JDBC 를 사용할 것이다.
	//Spring JDBC 는 JDBC 를 wrapping한 기술임.
	
	private DriverManagerDataSource dataSource;//Connection class 가 하던 역할을 대신 수행할 것이다.
	private JdbcTemplate template;// Statement + ResultSet 역할을 수행할 것이다.
	
	public MemoDAO() {
		//DB 연결
		this.dataSource = new DriverManagerDataSource();//객체 생성.
		this.dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		//this.dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		this.dataSource.setUrl("jdbc:oracle:thin:@192.168.0.9:1521:xe");
		this.dataSource.setUsername("hr");
		this.dataSource.setPassword("java1234");
		
		
		//template 생성
		this.template = new JdbcTemplate(this.dataSource);
		
		try {
			System.out.println(this.dataSource.getConnection().isClosed());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
