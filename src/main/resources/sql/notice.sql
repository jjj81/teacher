
drop table if exists notice;

create table notice(
title varchar(20) primary key,
body varchar(200) ,
teacherId varchar(30)
)
