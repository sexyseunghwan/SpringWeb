package com.test.spring;

import lombok.Data;

//lombok 기능
//- 우리가 클래스를 정의할 때 자주 하는 행동들을 대신 해주는 기능
//- @Data : 아래것들 모두 한번에 다 자동으로 만들어준다!.
//- @Getter : getter 를 자동으로 만들어준다.
//- @Setter : setter 를 자동으루 만들어준다.
//- @ToString : toString() 오버라이딩(덤프)

//더이상 dto 에 getter setter 작업 안한다.

//ctrl + shift + o -> 롬복 자동 생성
@Data
public class MemoDTO {
	//게터 세터도 없는데? -> lombok 으로 정해놓은 어노테이션이  우리대신에 추가적인 멤버를 다 만들어준다.
	
	//권장 사항
	//- DB 테이블의 컬럼명 == DTO 멤버변수명 == HTML 태그의 name 이 세개는 통일 시켜주는게 좋음.
	
	private String seq;
	private String name;
	private String memo;
	private String regdate;
	
	
}
