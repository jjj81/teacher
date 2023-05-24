
drop table if exists teacherLoginInfo;

create table teacherLoginInfo(
teacherId varchar(50) primary key,
passWord varchar(500) not null,
teacherName varchar(20) not null,
wantToManageClass varchar(100),
adminMessage varchar(100),
college varchar(20) not null,
faculty varchar(20) not null
);
