package com.zut.teacher.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.*;

import com.zut.teacher.entity.StudentInfo;

@Mapper
public interface StudentInfoMapper {

	@Select("select * from studentLoginInfo where className=#{className} order by studentId")
	List<StudentInfo> searchStudentByClassName(String className);

	@Select("select * from studentLoginInfo where studentId=#{studentId} order by studentId")
	StudentInfo searchStudentByStudentId(String studentId);

	@Insert("insert into studentLoginInfo(studentId,passWord,className) values(#{studentId},#{passWord},#{className})")
	void insertStudentInfo(StudentInfo studentInfo);
}
