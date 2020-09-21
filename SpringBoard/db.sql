-- 코드 게시판(스크랩 + 코드 조각 관리)
-- 싱글 유저
-- 코드 첨부(1개만)

-- 카테고리 테이블
create table tblCategory (
    seq number primary key,                             -- PK
    name varchar2(100) not null                         -- 카테고리명
);

-- 게시판 테이블
create table tblCode (
    seq number primary key,                             -- 글번호
    subject varchar2(500) not null,                     -- 제목
    content varchar2(2000) not null,                    -- 내용
    filename varchar2(300) not null,                    -- 첨부파일
    regdate date default date not null                  -- 작성시간
    cseq number not null references tblCategory(seq)    -- 카테고리(언어)
);