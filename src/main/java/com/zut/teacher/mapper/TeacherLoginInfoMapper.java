package com.zut.teacher.mapper;

import java.util.List;

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
	void updateTeacherNameByTeacherId(String teacherId, String teacherName);

	@Update("update teacherLoginInfo set passWord=#{passWord} where teacherId=#{teacherId}")
	void updatePassWord(String passWord, String teacherId);

	@Update("update teacherLoginInfo set wantToManageClass=#{leaveMessage} where teacherId=#{teacherId}")
	void updateLeaveMessageByTeacherId(String teacherId, String leaveMessage);

	// diff
	@Select("select * from classes")
	List<String> selectAllClass();

}
