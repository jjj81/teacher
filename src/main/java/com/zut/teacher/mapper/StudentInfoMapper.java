package com.zut.teacher.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.*;

import com.zut.teacher.entity.StudentInfo;

@Mapper
public interface StudentInfoMapper {

	@Select("select * from studentLoginInfo where studentId=#{studentId} order by studentId")
	StudentInfo searchStudentByStudentId(String studentId);

	@Insert("insert into studentLoginInfo(studentId,passWord,studentName,clazzId) values(#{studentId},#{passWord},#{studentName},#{clazzId})")
	void insertStudentInfo(StudentInfo studentInfo);

	@Delete("delete from studentLoginInfo where studentId=#{studentId}")
	void deleteStudentByStudentId(String studentId);

	@Select("select * from studentLoginInfo where clazzId=#{clazzId}")
	List<StudentInfo> selectStudentByClazzId(Integer clazzId);
}
