package com.zut.teacher.mapper;	

import com.zut.teacher.entity.LoginInfo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherLoginInfoMapper {
	@Insert("insert into teacherLoginInfo(teacherId,passWord) values(#{teacherId},#{passWord})")
	void insertTeacherInfo(LoginInfo loginInfo);

	@Select("select * from teacherLoginInfo where teacherId=#{id}")
	LoginInfo searchByTeacherId(String id);

}
