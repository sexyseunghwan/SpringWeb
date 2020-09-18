package com.test.spring;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

//Repository - 데이터 저장소 역할
@Repository//@Autowired 에 의해서 객체를 생성하겠습니다.- 자격부여
public class MemoDAO implements IMemo{//반드시 인터페이스 상속을 구현해야 나중에 스프링쓸때 오류 안난다
	
	//JDBC -> Spring JDBC 를 사용할 것이다.(***) 기본셋팅.
	//Spring JDBC 는 JDBC 를 wrapping한 기술임.
	
	private DriverManagerDataSource dataSource;//Connection class 가 하던 역할을 대신 수행할 것이다.
	private JdbcTemplate template;// Statement + ResultSet 역할을 수행할 것이다.
	
	public MemoDAO() {
		//DB 연결
		this.dataSource = new DriverManagerDataSource();//객체 생성.
		this.dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		//this.dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");//나는 지금 노트북 서버를 연결하고 있으니 노트북 아이피 주소 쳐야된다.
		this.dataSource.setUrl("jdbc:oracle:thin:@192.168.0.9:1521:xe");
		this.dataSource.setUsername("hr");
		this.dataSource.setPassword("java1234");
		
		
		//template 생성 
		this.template = new JdbcTemplate(this.dataSource);
		
		//연결 잘 되는지 확인하는 작업. 
//		try {
//			//System.out.println(this.dataSource.getConnection().isClosed());//연결 잘 되는지 확인하는것
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	
	
	
	@Override
	public int add(MemoDTO dto) {
		//글쓰기
		//Spring JDBC 방식 -> PreparedStatement 방식 + 업그레이드.
		String sql = "insert into tblMemo (seq,name,memo,regdate) values (seqMemo.nextVal,?,?,default)";
		
		//SQL 실행
		//stat.executeUpdate -> template.update() 로 대신함
		//stat.executeQuery -> template.query() 로 대신함
		
		//this.template.update(sql);//쿼리를 실행하라는 뜻. -> 물음표 어쩔거야...?! 인자값 처리해줘야 하니까!
		//인자값 처리를 위해 오브젝트 배열을 생성
//		Object[] args = new Object[2];
//		args[0] = dto.getName();
//		args[0] = dto.getMemo();
//		
//		int result = this.template.update(sql,args);//이런식으로 넣어주면 된다. result -> 성공하면 1 실패하면 0을 반환해준다.
//		
//		return result;
		
		//위의방식은 번잡해서 안씀
		
		return this.template.update(sql,new Object[] {dto.getName(),dto.getMemo()});//이런식으로 한줄로 써주면 된다.
		//try catch가 사라져서 아주 코드가 짧아지기도 한다
		//object~ 가 ?에 하나씩 들어갈 역할을 수행한다.
		
	}

	@Override
	public List<MemoDTO> list() {
		//목록보기
		
		String sql = "select * from tblMemo order by seq desc";
		
		//기존방식
		//1. Statement -> executeQuery()
		//2. ResultSet -> while(rs.next()) -> List<MemoDTO> + MemoDTO + setXXX(rs.getXXX) 이런식으로 해주는게 원래 했던방식
		
		//-원리
		// BeanPropertyRowMapper -> ?
		// Bean : 자바 객체(인스턴스) -> MemoDTO 를 뜻한다.
		// Property : setter,getter
		// 즉 BeanProperty -> dto 의 setter 
		// Row : DB 레코드
		// Mapper : 연결시켜주는 작업
		// BeanProperty + Row = Mapper
		
		//**************주의점*****************
		//dto멤버변수 이름과 테이블의 컬럼명이 "반드시" 같아야 한다!!!!
		
		return this.template.query(sql,new BeanPropertyRowMapper<MemoDTO>(MemoDTO.class));//query 가 List로 반환시킨다.
		//query가 List 를 반환해주는 역할을 수행.
	}

	@Override
	public int edit(MemoDTO dto) {
		//수정하기
		
		String sql = "update tblMemo set name = ?, memo = ? where seq = ?";
		
		return this.template.update(sql,new Object[] {dto.getName(), dto.getMemo(),dto.getSeq()});
	}
	
	
	@Override
	public int del(String seq) {
		//삭제하기
		
		String sql = "delete from tblMemo where seq = ?";
		
	
		return this.template.update(sql,new Object[] {seq});
	}



	@Override
	public MemoDTO get(String seq) {
		// 레코드 한줄 가져오는 작업을 수행해야 한다.
		
		String sql = "select * from tblMemo where seq = ?";
		
		//Spring JDBC 
		//1. 인자값 -> new Object[]
		//2. 반환값
		//	a. query -> List<DTO> 반환
		//	b. queryForObject() -> DTO 반환
		//	c. queryForInt() -> 정수 1개 반환
		
		return this.template.queryForObject(sql,new Object[] {seq}, new BeanPropertyRowMapper<MemoDTO>(MemoDTO.class));
		//sql 에서 seq 를 받아서 하나씩 다 체크해줘서 담아서 보내준다!!!..
	}
}
