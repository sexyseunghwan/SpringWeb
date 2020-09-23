

--Æ®·£Àè¼Ç

create table tblTran (
    seq number primary key,
    name varchar2(30) not null,
    point number default 100 not null
);

create sequence seqTran;

select * from tblTran;
select * from tblBoard;

drop table tblBoard cascade constraints;

create table tblBoard(
    seq number primary key,
    subject varchar2(100) not null,
    tseq number not null references tblTran(seq)
);

drop sequence seqBoard;
create sequence seqBoard;

select * from tblBoard;

insert into tblTran values (seqTran.nextVal,'È«±æµ¿',default);

commit;



