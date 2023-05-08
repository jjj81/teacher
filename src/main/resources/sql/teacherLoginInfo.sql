
drop table if exists teacherLoginInfo;

create table teacherLoginInfo(
teacherId varchar(50) primary key,
passWord varchar(500) not null,
teacherName varchar(20) default null,
wantToManageClass varchar(100)
);
