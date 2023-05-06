package com.zut.teacher.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.*;

import com.zut.teacher.entity.TeacherPowerToClass;

@Mapper
public interface TeacherPowerToClassMapper {
	@Select("select * from teacherPowerToClass where teacherId=#{teacherId}")
	List<TeacherPowerToClass> searchTeacherPowerToClassById(String teacherId);
}
