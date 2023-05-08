package com.zut.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.zut.teacher.entity.StudentInfo;
import com.zut.teacher.entity.TeacherPowerToClass;
import com.zut.teacher.mapper.StudentInfoMapper;
import com.zut.teacher.mapper.TeacherPowerToClassMapper;

@Service
public class TeacherInfoService {

	@Autowired
	private TeacherPowerToClassMapper teacherPowerToClassMapper;

	@Autowired
	private StudentInfoMapper studentInfoMapper;

	public List<StudentInfo> searchTeacherCanManagerStudentAll(String teacherId) {
		List<StudentInfo> result = null;
		List<TeacherPowerToClass> teacherCanManagerClass = teacherPowerToClassMapper
				.searchTeacherPowerToClassById(teacherId);
		for (TeacherPowerToClass teacherPowerToClass : teacherCanManagerClass) {
			if (result == null)
				result = studentInfoMapper.searchStudentByClassName(teacherPowerToClass.getClassName());
			else
				for (StudentInfo studentInfo : studentInfoMapper
						.searchStudentByClassName(teacherPowerToClass.getClassName())) {
					result.add(studentInfo);
				}

			;

		}
		return result;

	}

}
