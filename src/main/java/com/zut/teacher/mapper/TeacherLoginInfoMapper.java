package com.zut.teacher.mapper;

import com.zut.teacher.entity.TeacherLoginInfo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherLoginInfoMapper {
	@Insert("insert into teacherLoginInfo(teacherId,passWord) values(#{teacherId},#{passWord})")
	void insertTeacherInfo(TeacherLoginInfo loginInfo);

	@Select("select * from teacherLoginInfo where teacherId=#{id}")
	TeacherLoginInfo searchByTeacherId(String id);

	@Update("update teacherLoginInfo set teacherName=#{teacherName} where teacherId=#{teacherId}")
	void updateTeacherNameByTeacherId(TeacherLoginInfo teacherInfo);

}
