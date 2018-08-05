select * from emp
drop table latestarticle;
create table latestarticle (
articleID NUMBER(5),
title varchar2(20),
description varchar2(400),
articleDate date default sysdate
);

insert into LATESTARTICLE  values(3,'third','this is third',sysdate);
Select * from LATESTARTICLE;

select * from LATESTARTICLE where articleID between (Select max(articleID)-(10*:a) from latestarticle) and (select max(articleID)-(10*:b)  from latestarticle) order by articledate desc