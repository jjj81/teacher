package com.zut.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.zut.teacher.entity.StudentDoExerciseInfo;
import com.zut.teacher.entity.StudentInfo;
import com.zut.teacher.entity.StudentOrganization;
import com.zut.teacher.entity.TeacherPowerToClass;
import com.zut.teacher.mapper.ClazzMapper;
import com.zut.teacher.mapper.StudentDoExerciseInfoMapper;
import com.zut.teacher.mapper.StudentInfoMapper;
import com.zut.teacher.mapper.TeacherPowerToClassMapper;

@Service
public class TeacherInfoService {

	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private TeacherPowerToClassMapper teacherPowerToClassMapper;

	@Autowired
	private StudentDoExerciseInfoMapper studentDoExerciseInfoMapper;

	@Autowired
	private StudentInfoMapper studentInfoMapper;

	public List<StudentOrganization> showStudentInfo(List<StudentInfo> stuList) {
		List<StudentOrganization> so = new ArrayList<>();
		for (StudentInfo s : stuList) {
			StudentOrganization studentOrganization = new StudentOrganization();
			studentOrganization.setStudentId(s.getStudentId());
			studentOrganization.setStudentName(s.getStudentName());
			studentOrganization.setClazz(clazzMapper.selectClazzById(s.getClazzId()).getClazz());
			studentOrganization.setFaculty(clazzMapper
					.selectFacultyById(clazzMapper.selectClazzById(s.getClazzId()).getParentId()).getFaculty());
			studentOrganization.setCollege(clazzMapper
					.selectCollegeById2(clazzMapper
							.selectFacultyById(clazzMapper.selectClazzById(s.getClazzId()).getParentId()).getParentId())
					.getCollege());
			so.add(studentOrganization);
		}
		return so;
	}

	public List<StudentInfo> teacherCanManagerStudents(String teacherId) {

		List<StudentInfo> si = new ArrayList<>();
		for (TeacherPowerToClass teacherPowerToClass : teacherPowerToClassMapper
				.searchTeacherPowerToClassById(teacherId)) {
			for (StudentInfo s : studentInfoMapper.selectStudentByClazzId(teacherPowerToClass.getClazzId())) {
				si.add(s);
			}

		}

		return si;

	}

	public List<StudentDoExerciseInfo> teacherCantManageDoExerciseInfo(List<StudentInfo> studList) {
		List<StudentDoExerciseInfo> sde = new ArrayList<>();
		for (StudentInfo s : studList) {
			for (StudentDoExerciseInfo studentDoExerciseInfo : studentDoExerciseInfoMapper
					.selectDoExerciseInfoByStudentId(s.getStudentId())) {
				sde.add(studentDoExerciseInfo);
			}
		}
		return sde;
	}

}
